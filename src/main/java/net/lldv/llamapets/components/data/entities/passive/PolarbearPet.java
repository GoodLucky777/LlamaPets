package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.passive.EntityPolarBear;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class PolarbearPet extends Pet {

    public PolarbearPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.movementSpeed = 1.0f;
    }

    @Override
    public int getNetworkId() {
        return EntityPolarBear.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return 1.3f;
    }

    @Override
    public float getHeight() {
        return 1.4f;
    }

}
