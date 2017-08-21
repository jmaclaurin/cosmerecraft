package com.mistcraft.common.capability;

public class MetalReserve implements IMetalReserve {
    private float metalReserve = 0F;

    public float getMetalReserve() {
        return this.metalReserve;
    }

    public void setMetalReserve(float volume) {
        this.metalReserve = volume;
    }

    public void burnMetal(float volume) {
        this.metalReserve -= volume;
    }

    public void fillMetal(float volume) {
        this.metalReserve += volume;
    }
}
