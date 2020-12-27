package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.mob.EntitySnowGolem;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class SnowgolemPet extends Pet {

    public SnowgolemPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.movementSpeed = 1.0f;
    }

    @Override
    public int getNetworkId() {
        return EntitySnowGolem.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .7f;
    }

    @Override
    public float getHeight() {
        return 1.9f;
    }

}
