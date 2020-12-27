package net.lldv.llamapets.components.data.entities.hostile;

import cn.nukkit.entity.mob.EntityCaveSpider;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class CaveSpiderPet extends Pet {

    public CaveSpiderPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.setMovementSpeed(1.0f);
    }

    public int getNetworkId() {
        return EntityCaveSpider.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .7f;
    }

    @Override
    public float getHeight() {
        return .5f;
    }

}
