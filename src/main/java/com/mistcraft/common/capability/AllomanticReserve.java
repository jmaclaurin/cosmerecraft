package com.mistcraft.common.capability;

import com.mistcraft.common.util.AllomanticMetal;

import java.util.HashMap;
import java.util.Map;

public class AllomanticReserve implements IAllomanticReserve {
    private Map<AllomanticMetal, Float> metalReserves = new HashMap<>();

    public AllomanticReserve() {
        for(AllomanticMetal metal : AllomanticMetal.values()) {
            metalReserves.put(metal, 0F);
        }
    }

    public float getMetalReserve(AllomanticMetal metal) {
        return metalReserves.get(metal);
    }

    public void setMetalReserve(AllomanticMetal metal, float amount) {
        metalReserves.put(metal, amount);
    }

    public void burnMetalReserve(AllomanticMetal metal, float amount) {
        metalReserves.put(metal, metalReserves.get(metal) - amount);
    }

    public void fillMetalReserve(AllomanticMetal metal, float amount) {
        metalReserves.put(metal, metalReserves.get(metal) + amount);
    }
}
