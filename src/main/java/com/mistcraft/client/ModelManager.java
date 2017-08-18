package com.mistcraft.client;

import com.mistcraft.Mistcraft;
import com.mistcraft.common.block.ModBlocks;
import com.mistcraft.common.item.EnumFileType;
import com.mistcraft.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
        registerBlockModelAsItem(ModBlocks.COPPER_BLOCK);
        registerBlockModelAsItem(ModBlocks.TIN_BLOCK);
        registerBlockModelAsItem(ModBlocks.ZINC_BLOCK);
    }

    private static void registerItemModels() {
        registerItemModel(ModItems.COPPER_INGOT);
        registerItemModel(ModItems.COPPER_NUGGET);
        registerItemModel(ModItems.COPPER_SHAVINGS);
        registerItemModel(ModItems.TIN_INGOT);
        registerItemModel(ModItems.TIN_NUGGET);
        registerItemModel(ModItems.TIN_SHAVINGS);
        registerItemModel(ModItems.ZINC_INGOT);
        registerItemModel(ModItems.ZINC_NUGGET);
        registerItemModel(ModItems.ZINC_SHAVINGS);

        for(int i = 0; i < EnumFileType.values().length; i++){
//            ModelBakery.registerItemVariants(ModItems.FILE, new ModelResourceLocation(Mistcraft.MODID + ":" +
//                    EnumFileType.values()[i].getUnlocalizedName(), "inventory"));
//            ModelLoader.setCustomModelResourceLocation(ModItems.FILE, i,
//                    new ModelResourceLocation(Mistcraft.MODID + ":" +
//                            EnumFileType.values()[i].getUnlocalizedName(), "inventory"));
        }
//
//        ModelBakery.registerItemVariants(ModItems.FILE,
//                new ModelResourceLocation("mistcraft:steel_file", "inventory"),
//                new ModelResourceLocation("mistcraft:iron_file", "inventory"));

        ModelLoader.setCustomModelResourceLocation(ModItems.FILE, 0,
                    new ModelResourceLocation("mistcraft:file", "steel_file"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FILE, 1,
                new ModelResourceLocation("mistcraft:file", "iron_file"));
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
