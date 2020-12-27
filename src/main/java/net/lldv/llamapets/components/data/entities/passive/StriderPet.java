package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.passive.EntityStrider;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class StriderPet extends Pet {

    public StriderPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.movementSpeed = 1.0f;
    }

    @Override
    public int getNetworkId() {
        return EntityStrider.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .9f;
    }

    @Override
    public float getHeight() {
        return 1.7f;
    }
}
