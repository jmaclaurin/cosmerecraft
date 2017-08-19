package com.mistcraft.common.item;

public enum EnumFileType {
    IRON("iron_file", 16),
    STEEL("steel_file", 32);

    private final String unlocalizedName;
    private final int durability;

    EnumFileType(String unlocalizedName, int durability) {
        this.unlocalizedName = unlocalizedName;
        this.durability = durability;
    }

    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }

    public int getDurability() {
        return durability;
    }
}
