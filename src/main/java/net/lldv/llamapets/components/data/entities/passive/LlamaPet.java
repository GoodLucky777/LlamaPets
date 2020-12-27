package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.passive.EntityLlama;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class LlamaPet extends Pet {

    public LlamaPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setDataFlag(DATA_FLAG_BABY, DATA_TYPE_BYTE);
        this.movementSpeed = 1.0f;
    }

    @Override
    public int getNetworkId() {
        return EntityLlama.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .9f;
    }

    @Override
    public float getHeight() {
        return 1.87f;
    }

    @Override
    public float getEyeHeight() {
        return 1.2f;
    }

}
