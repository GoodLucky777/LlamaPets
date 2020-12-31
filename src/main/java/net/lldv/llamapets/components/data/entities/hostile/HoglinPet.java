package net.lldv.llamapets.components.data.entities.hostile;

import cn.nukkit.entity.mob.EntityHoglin;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class HoglinPet extends Pet {

    public HoglinPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setMovementSpeed(1.0f);
        this.distance = 6;
    }

    public int getNetworkId() {
        return EntityHoglin.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .9f;
    }

    @Override
    public float getHeight() {
        return .9f;
    }

}
