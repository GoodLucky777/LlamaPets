package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.passive.EntityTurtle;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class TurtlePet extends Pet {

    public TurtlePet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.movementSpeed = 1.0f;
    }

    @Override
    public int getNetworkId() {
        return EntityTurtle.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return 1.2f;
    }

    @Override
    public float getHeight() {
        return .4f;
    }
}
