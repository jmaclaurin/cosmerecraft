package com.mistcraft.client;

import com.mistcraft.Mistcraft;
import com.mistcraft.common.block.ModBlocks;
import com.mistcraft.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.Set;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid=com.mistcraft.Mistcraft.MODID, value=Side.CLIENT)
public class ModelManager {
    public ModelManager() {}

    @SubscribeEvent
    public static void registerAllModels(ModelRegistryEvent event) {
        registerBlockModels();
        registerItemModels();
    }

    private static void registerBlockModels() {
        registerBlockModelAsItem(ModBlocks.COPPER_ORE);
        registerBlockModelAsItem(ModBlocks.TIN_ORE);
        registerBlockModelAsItem(ModBlocks.ZINC_ORE);
    }

    private static void registerItemModels() {
        registerItemModel(ModItems.COPPER_INGOT);
        registerItemModel(ModItems.COPPER_NUGGET);
    }

    public static void registerItemModel(Item item, String variant,  int meta) {
        ModelLoader.setCustomModelResourceLocation(
                item, meta, new ModelResourceLocation(item.getRegistryName(), variant));
    }

    private static void registerItemModel(Item item, String variant) {
        registerItemModel(item, variant, 0);
    }

    private static void registerItemModel(Item item) {
        registerItemModel(item, "inventory", 0);
    }

    private static void registerBlockModelAsItem(Block block, String variant, int meta) {
        registerItemModel(Item.getItemFromBlock(block), variant, meta);
    }

    private static void registerBlockModelAsItem(Block block, String variant) {
        registerItemModel(Item.getItemFromBlock(block), variant, 0);
    }

    private static void registerBlockModelAsItem(Block block) {
        registerItemModel(Item.getItemFromBlock(block), "inventory", 0);
    }
}
