package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.passive.EntityRabbit;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class RabbitPet extends Pet {

    public RabbitPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.movementSpeed = 1.0f;
    }

    @Override
    public int getNetworkId() {
        return EntityRabbit.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .4f;
    }

    @Override
    public float getHeight() {
        return .5f;
    }
}
