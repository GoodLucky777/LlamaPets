package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.passive.EntityPanda;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class PandaPet extends Pet {

    public PandaPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.movementSpeed = 1.0f;
    }

    @Override
    public int getNetworkId() {
        return EntityPanda.NETWORK_ID;
    }

    @Override
    public float getLength() {
        return 1.825F;
    }

    @Override
    public float getWidth() {
        return 1.125F;
    }

    @Override
    public float getHeight() {
        return 1.25F;
    }

}
