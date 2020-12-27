package net.lldv.llamapets.components.forms;

import cn.nukkit.Player;
import cn.nukkit.form.element.*;
import lombok.RequiredArgsConstructor;
import net.lldv.llamaeconomy.LlamaEconomy;
import net.lldv.llamapets.components.data.PetData;
import net.lldv.llamapets.components.forms.custom.CustomForm;
import net.lldv.llamapets.components.forms.modal.ModalForm;
import net.lldv.llamapets.components.forms.simple.SimpleForm;
import net.lldv.llamapets.components.language.Language;
import net.lldv.llamapets.components.provider.Provider;

import java.util.HashMap;
import java.util.LinkedList;

@RequiredArgsConstructor
public class FormWindows {

    private final Provider provider;

    public void openPetMenu(final Player player) {
        this.provider.getPetData(player.getName(), petData -> {
            SimpleForm form = new SimpleForm.Builder(Language.getNP("ui.petmenu.title"), Language.getNP("ui.petmenu.content"))
                    .addButton(new ElementButton(Language.getNP("ui.petmenu.mypets", petData.getOwnedPets().size())), e -> this.openAvailablePets(e, petData))
                    .addButton(new ElementButton(Language.getNP("ui.petmenu.petshop")), e -> this.openPetShop(e, petData))
                    .addButton(new ElementButton(Language.getNP("ui.petmenu.settings")), this::openPetSettings)
                    .build();
            form.send(player);
        });
    }

    public void openAvailablePets(final Player player, final PetData pets) {
        PetData.Meta meta = this.provider.convertPetData(pets, pets.getPetData());
        if (pets.getOwnedPets().size() == 0) {
            player.sendMessage(Language.get("pet.not.owning"));
            return;
        }

        LinkedList<String> list = new LinkedList<>();
        pets.getOwnedPets().forEach(e -> list.add(this.convertPetToName(e)));

        CustomForm form = new CustomForm.Builder(Language.getNP("ui.availablepets.title"))
                .addElement(new ElementLabel(Language.getNP("ui.availablepets.label")))
                .addElement(new ElementDropdown(Language.getNP("ui.availablepets.select"), list, 0))
                .addElement(new ElementInput(Language.getNP("ui.availablepets.name"), Language.getNP("ui.availablepets.name.placeholder"), meta.getName()))
                .addElement(new ElementToggle(Language.getNP("ui.availablepets.baby"), meta.isBaby()))
                .onSubmit((g, h) -> {
                    String pet = h.getDropdownResponse(1).getElementContent();
                    String name = h.getInputResponse(2);
                    boolean baby = h.getToggleResponse(3);
                    if (name == null || name.isEmpty() || name.length() > 32) {
                        g.sendMessage(Language.get("pet.invalid.name"));
                        return;
                    }
                    this.provider.changeData(g.getName(), PetData.Type.NAME_KEY, name);
                    this.provider.changeData(g.getName(), PetData.Type.BABY_KEY, String.valueOf(baby));
                    this.provider.changePet(g.getName(), this.convertNameToPet(pet));
                    g.sendMessage(Language.get("pet.spawned"));
                })
                .build();
        form.send(player);
    }

    public void openPetShop(final Player player, final PetData petData) {
        HashMap<String, Double> pets = PetData.cachedPetList;
        petData.getOwnedPets().forEach(pets::remove);

        SimpleForm.Builder form = new SimpleForm.Builder(Language.getNP("ui.petshop.title"), Language.getNP("ui.petshop.content"));
        pets.keySet().forEach(m -> form.addButton(new ElementButton(Language.getNP("ui.petshop.button", this.convertPetToName(m), pets.get(m))), e -> {
            this.openBuyPet(e, m);
        }));
        form.addButton(new ElementButton(Language.getNP("ui.back")), this::openPetMenu);
        form.build().send(player);
    }

    public void openBuyPet(final Player player, final String pet) {
        ModalForm form = new ModalForm.Builder(Language.getNP("ui.buypet.title"),
                Language.getNP("ui.buypet.content", this.convertPetToName(pet), PetData.cachedPetList.get(pet)),
                Language.getNP("ui.buypet.buy"), Language.getNP("ui.buypet.cancel"))
                .onYes(f -> {
                    if (LlamaEconomy.getAPI().getMoney(f.getName()) >= PetData.cachedPetList.get(pet)) {
                        this.provider.buyPet(f, pet);
                        player.sendMessage(Language.get("pet.bought", this.convertPetToName(pet)));
                    } else player.sendMessage(Language.get("pet.economy.invalid"));
                })
                .onNo(this::openPetMenu)
                .build();
        form.send(player);
    }

    public void openPetSettings(final Player player) {

    }

    private String convertPetToName(final String pet) {
        return Language.getNP("pet." + pet);
    }

    private String convertNameToPet(final String name) {
        String f = "null";
        for (String g : Language.messages.keySet()) {
            if (Language.getNP(g).equals(name)) {
                f = g.split("\\.")[1];
            }
        }
        return f;
    }

}
