package com.mistcraft.common.capability;

public interface IAllomanticReserve {
    public float getMetalReserve(AllomanticMetal metal);
    public void setMetalReserve(AllomanticMetal metal, float amount);
    public void burnMetalReserve(AllomanticMetal metal, float amount);
    public void fillMetalReserve(AllomanticMetal metal, float amount);
}
