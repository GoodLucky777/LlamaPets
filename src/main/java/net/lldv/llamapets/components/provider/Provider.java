package net.lldv.llamapets.components.provider;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.utils.DyeColor;
import lombok.RequiredArgsConstructor;
import net.lldv.llamaeconomy.LlamaEconomy;
import net.lldv.llamapets.components.data.entities.Pet;
import net.lldv.llamapets.components.data.PetData;
import net.lldv.llamapets.components.provider.data.Collection;
import net.lldv.llamapets.components.provider.data.CollectionFields;
import net.lldv.llamapets.components.provider.data.UDocument;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class Provider {

    private final UniversalClient client;

    private Collection dataCollection;

    public void init() {
        this.dataCollection = this.client.getCollection("data");
        this.dataCollection.createCollection(
                new CollectionFields("player", CollectionFields.Type.VARCHAR, 32)
                        .append("owned", CollectionFields.Type.LONGTEXT)
                        .append("pet", CollectionFields.Type.VARCHAR, 64)
                        .append("pet_data", CollectionFields.Type.LONGTEXT)
        );
    }

    public void disconnect() {
        this.client.disconnect();
    }

    public void createDatabasePlayer(final String player) {
        CompletableFuture.runAsync(() -> {
            if (this.dataCollection.find("player", player).first() == null) {
                List<String> owned = new ArrayList<>();
                List<String> data = new ArrayList<>();
                data.add("name:" + player + "'s Pet");
                data.add("baby:false");
                data.add("color:WHITE");
                this.dataCollection.insert(
                        new UDocument("player", player)
                                .append("owned", owned)
                                .append("pet", "null")
                                .append("pet_data", data)
                );
            }
        });
    }

    public void changeData(final String player, final String key, final String value) {
        this.getPetData(player, data -> CompletableFuture.runAsync(() -> {
            PetData.Meta rawData = this.convertPetData(data, data.getPetData());
            List<String> list = data.getPetData();
            switch (key) {
                case PetData.Type.NAME_KEY:
                    list.remove("name:" + rawData.getName());
                    list.add("name:" + value);
                    break;
                case PetData.Type.BABY_KEY:
                    list.remove("baby:" + rawData.isBaby());
                    list.add("baby:" + value);
                    break;
                case PetData.Type.COLOR_KEY:
                    list.remove("color:" + rawData.getColor().name().toUpperCase());
                    list.add("color:" + value.toUpperCase());
                    break;
                default:
                    break;
            }
            this.dataCollection.update("player", player, new UDocument("pet_data", list));
        }));
    }

    public PetData.Meta convertPetData(final PetData petData, final List<String> data) {
        String name = "";
        boolean baby = false;
        DyeColor color = DyeColor.WHITE;
        for (String p : data) {
            if (p.startsWith("name")) name = p.split(":")[1];
            else if (p.startsWith("baby")) baby = Boolean.parseBoolean(p.split(":")[1]);
            else if (p.startsWith("color")) color = DyeColor.valueOf(p.split(":")[1]);
        }
        return new PetData.Meta(petData.getPet(), name, baby, color);
    }

    public void changePet(final String player, final String pet) {
        CompletableFuture.runAsync(() -> {
            this.dataCollection.update("player", player, new UDocument("pet", pet));

            Player oPlayer = Server.getInstance().getPlayer(player);
            if (oPlayer != null) {
                this.getPetData(player, data -> {
                    Pet entityPet = PetData.currentPet.get(player);
                    if (entityPet != null) {
                        entityPet.despawnFromAll();
                        entityPet.close();
                    }

                    PetData.Meta meta = this.convertPetData(data, data.getPetData());
                    meta.create(oPlayer);
                });
            }
        });
    }


    public void getPetData(final String player, final Consumer<PetData> petData) {
        CompletableFuture.runAsync(() -> {
            final UDocument document = this.dataCollection.find("player", player).first();
            PetData rawData = null;
            if (document != null) {
                List<String> list = document.getList("owned");
                String pet = document.getString("pet");
                List<String> pet_data = document.getList("pet_data");
                rawData = new PetData(player, list, pet, pet_data);
            }
            petData.accept(rawData);
        });
    }

    public void buyPet(final Player player, final String pet) {
        this.getPetData(player.getName(), data -> CompletableFuture.runAsync(() -> {
            List<String> list = data.getOwnedPets();
            list.add(pet);
            LlamaEconomy.getAPI().reduceMoney(player.getName(), PetData.cachedPetList.get(pet));
            this.dataCollection.update("player", player, new UDocument("owned", list));
        }));
    }

}
