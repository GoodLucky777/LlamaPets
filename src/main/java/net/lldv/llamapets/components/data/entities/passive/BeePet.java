package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.passive.EntityBee;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class BeePet extends Pet {

    public BeePet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return EntityBee.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .7f;
    }

    @Override
    public float getHeight() {
        return .6f;
    }

}
