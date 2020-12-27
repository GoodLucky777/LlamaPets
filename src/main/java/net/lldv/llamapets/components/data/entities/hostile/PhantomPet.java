package net.lldv.llamapets.components.data.entities.hostile;

import cn.nukkit.entity.mob.EntityPhantom;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class PhantomPet extends Pet {

    public PhantomPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setMovementSpeed(1.0f);
    }

    public int getNetworkId() {
        return EntityPhantom.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .9f;
    }

    @Override
    public float getHeight() {
        return .5f;
    }

}
