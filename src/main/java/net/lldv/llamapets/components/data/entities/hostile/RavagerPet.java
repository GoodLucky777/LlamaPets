package net.lldv.llamapets.components.data.entities.hostile;

import cn.nukkit.entity.mob.EntityRavager;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class RavagerPet extends Pet {

    public RavagerPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setMovementSpeed(1.0f);
    }

    public int getNetworkId() {
        return EntityRavager.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return 1.9f;
    }

    @Override
    public float getHeight() {
        return 1.2f;
    }

}
