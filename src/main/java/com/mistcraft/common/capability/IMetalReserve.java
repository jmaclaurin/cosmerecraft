package com.mistcraft.common.capability;

public interface IMetalReserve {
    public float getMetalReserve();
    public void setMetalReserve(float volume);
    public void burnMetal(float volume);
    public void fillMetal(float volume);
}
