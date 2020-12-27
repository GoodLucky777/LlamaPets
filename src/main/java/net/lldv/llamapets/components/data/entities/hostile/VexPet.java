package net.lldv.llamapets.components.data.entities.hostile;

import cn.nukkit.entity.mob.EntityVex;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class VexPet extends Pet {

    public VexPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setMovementSpeed(1.0f);
    }

    public int getNetworkId() {
        return EntityVex.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .4f;
    }

    @Override
    public float getHeight() {
        return .8f;
    }

}
