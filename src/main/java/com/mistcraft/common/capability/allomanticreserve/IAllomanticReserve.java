package com.mistcraft.common.capability.allomanticreserve;

import com.mistcraft.common.util.AllomanticMetal;

public interface IAllomanticReserve {
    float getMetalReserve(AllomanticMetal metal);
    void setMetalReserve(AllomanticMetal metal, float amount);
    void burnMetalReserve(AllomanticMetal metal, float amount);
    void fillMetalReserve(AllomanticMetal metal, float amount);
}
