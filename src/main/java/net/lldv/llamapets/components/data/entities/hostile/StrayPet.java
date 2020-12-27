package net.lldv.llamapets.components.data.entities.hostile;

import cn.nukkit.entity.mob.EntityStray;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class StrayPet extends Pet {

    public StrayPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setMovementSpeed(1.0f);
    }

    public int getNetworkId() {
        return EntityStray.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .6f;
    }

    @Override
    public float getHeight() {
        return 1.99f;
    }

}
