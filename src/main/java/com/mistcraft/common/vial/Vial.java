package com.mistcraft.common.vial;

import com.mistcraft.common.util.AllomanticMetal;
import net.minecraft.item.ItemStack;

public class Vial {
    private final String key;
    private int strength;
    private AllomanticMetal metal;

    public Vial(String key, AllomanticMetal metal, int stength) {
        this.key = key;
        this.metal = metal;
        this.strength = stength;
    }

    public String getKey() {
        return key;
    }

    public String getUnlocalizedName() {
        return key;
    }

    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName();
    }

    public AllomanticMetal getMetal() {
        return metal;
    }

    public int getStrength() {
        return this.strength;
    }

    public static Vial getDefaultInstance() {
        return new Vial("empty", null, 0);
    }
}
