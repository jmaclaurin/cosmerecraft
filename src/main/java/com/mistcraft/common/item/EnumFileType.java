package com.mistcraft.common.item;

public enum EnumFileType {
    IRON("iron_file", 10),
    STEEL("steel_file", 30);

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
