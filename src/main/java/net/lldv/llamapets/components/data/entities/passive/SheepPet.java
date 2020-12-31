package net.lldv.llamapets.components.data.entities.passive;

import cn.nukkit.entity.data.ByteEntityData;
import cn.nukkit.entity.passive.EntitySheep;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import net.lldv.llamapets.components.data.entities.Pet;

public class SheepPet extends Pet {

    public SheepPet(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.movementSpeed = 1.0f;
    }

    @Override
    public int getNetworkId() {
        return EntitySheep.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        return .9f;
    }

    @Override
    public float getHeight() {
        return 1.3f;
    }

    public int getColor() {
        return this.namedTag.getByte("Color");
    }

    public void setColor(int color) {
        this.setDataProperty(new ByteEntityData(3, color));
        this.namedTag.putByte("Color", color);
        this.saveNBT();
    }

}
