package com.mistcraft.common;

import com.mistcraft.Mistcraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class MistcraftCreativeTab extends CreativeTabs {
    public static final MistcraftCreativeTab INSTANCE = new MistcraftCreativeTab();

    public MistcraftCreativeTab() {
        super(Mistcraft.MODID);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(Items.IRON_NUGGET);
    }

    @Override
    public ItemStack getTabIconItem() {
        return getIconItemStack();
    }
}
