package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.passive.EntityCow;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class CowPet extends Pet {

    public CowPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.movementSpeed = 1.0f;
    }

    @Override
    public int getNetworkId() {
        return EntityCow.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .9f;
    }

    @Override
    public float getHeight() {
        return 1.4f;
    }

}
