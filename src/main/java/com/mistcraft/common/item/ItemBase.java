package com.mistcraft.common.item;

import com.mistcraft.common.MistcraftCreativeTab;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item {
    public ItemBase(String unlocalizedName, int maxStackSize, int maxDamage) {
        this.setUnlocalizedName(unlocalizedName);
        this.setMaxStackSize(maxStackSize);
        this.setMaxDamage(maxDamage);
        this.setRegistryName(new ResourceLocation(com.mistcraft.Mistcraft.MODID, unlocalizedName));
        this.setCreativeTab(MistcraftCreativeTab.INSTANCE);
    }

    public ItemBase(String unlocalizedName, int maxStackSize) {
        this(unlocalizedName, maxStackSize, 0)
    }

    public ItemBase(String unlocalizedName) {
        this(unlocalizedName, 64, 0)
    }
}
