package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.passive.EntityVillager;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class VillagerPet extends Pet {

    public VillagerPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.movementSpeed = 1.0f;
    }

    @Override
    public int getNetworkId() {
        return EntityVillager.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .6f;
    }

    @Override
    public float getHeight() {
        return 1.8f;
    }

}
