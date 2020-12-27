package net.lldv.llamapets.components.data.entities.hostile;

import cn.nukkit.entity.mob.EntityWitherSkeleton;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class WitherSkeletonPet extends Pet {

    public WitherSkeletonPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setMovementSpeed(1.0f);
    }

    public int getNetworkId() {
        return EntityWitherSkeleton.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .7f;
    }

    @Override
    public float getHeight() {
        return 2.4f;
    }

}
