package net.lldv.llamapets.components.data.entities.hostile;

import cn.nukkit.entity.mob.EntitySilverfish;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class SilverfishPet extends Pet {

    public SilverfishPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setMovementSpeed(1.0f);
    }

    public int getNetworkId() {
        return EntitySilverfish.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .4f;
    }

    @Override
    public float getHeight() {
        return .3f;
    }

}
