package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.passive.EntityMule;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class MulePet extends Pet {

    public MulePet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.movementSpeed = 1.0f;
        this.distance = 5;
    }

    @Override
    public int getNetworkId() {
        return EntityMule.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return 1.3965f;
    }

    @Override
    public float getHeight() {
        return 1.6f;
    }

}
