package net.lldv.llamapets.components.data.entities.hostile;

import cn.nukkit.entity.mob.EntityElderGuardian;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class ElderGuardianPet extends Pet {

    public ElderGuardianPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setMovementSpeed(1.0f);
        this.setDataFlag(0, 33, true);
    }

    public int getNetworkId() {
        return EntityElderGuardian.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return 1.9975f;
    }

    @Override
    public float getHeight() {
        return 1.9975f;
    }

}
