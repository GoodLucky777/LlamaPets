package net.lldv.llamapets.listeners;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import lombok.RequiredArgsConstructor;
import net.lldv.llamapets.LlamaPets;
import net.lldv.llamapets.components.data.entities.Pet;
import net.lldv.llamapets.components.data.PetData;

@RequiredArgsConstructor
public class EventListener implements Listener {

    private final LlamaPets llamaPets;

    @EventHandler
    public void on(final EntityDamageEvent event) {
        if (event.getEntity() instanceof Pet) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void on(final PlayerJoinEvent event) {
        this.llamaPets.provider.createDatabasePlayer(event.getPlayer().getName());
    }

    @EventHandler
    public void on(final PlayerQuitEvent event) {
        if (PetData.currentPet.get(event.getPlayer().getName()) != null) {
            final Pet pet = PetData.currentPet.get(event.getPlayer().getName());
            PetData.currentPet.remove(event.getPlayer().getName());
            pet.despawnFromAll();
            pet.close();
        }
    }

}
