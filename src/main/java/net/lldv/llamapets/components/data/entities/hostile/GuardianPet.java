package net.lldv.llamapets.components.data.entities.hostile;

import cn.nukkit.entity.mob.EntityGuardian;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class GuardianPet extends Pet {

    public GuardianPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setMovementSpeed(1.0f);
    }

    public int getNetworkId() {
        return EntityGuardian.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .85f;
    }

    @Override
    public float getHeight() {
        return .85f;
    }

}
