package com.mistcraft.common.recipe;

import com.mistcraft.common.block.ModBlocks;
import com.mistcraft.common.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void registerSmeltingRecipes() {
        GameRegistry.addSmelting(ModBlocks.COPPER_ORE, new ItemStack(ModItems.COPPER_INGOT), 0.5F);
        GameRegistry.addSmelting(ModBlocks.TIN_ORE, new ItemStack(ModItems.TIN_INGOT), 0.5F);
        GameRegistry.addSmelting(ModBlocks.ZINC_ORE, new ItemStack(ModItems.ZINC_INGOT), 0.5F);
    }
}
