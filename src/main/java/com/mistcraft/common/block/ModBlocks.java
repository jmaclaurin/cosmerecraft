package com.mistcraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = com.mistcraft.Mistcraft.MODID)
public final class ModBlocks {
    public static Block BRASS_BLOCK = new BlockBase("brass_block");
    public static Block BRONZE_BLOCK = new BlockBase("bronze_block");
    public static Block COPPER_BLOCK = new BlockBase("copper_block");
    public static Block COPPER_ORE = new BlockBase("copper_ore");
    public static Block ELECTRUM_BLOCK = new BlockBase("electrum_block");
    public static Block PEWTER_BLOCK = new BlockBase("pewter_block");
    public static Block STEEL_BLOCK = new BlockBase("steel_block");
    public static Block TIN_BLOCK = new BlockBase("tin_block");
    public static Block TIN_ORE = new BlockBase("tin_ore");
    public static Block ZINC_BLOCK = new BlockBase("zinc_block");
    public static Block ZINC_ORE = new BlockBase("zinc_ore");

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                BRASS_BLOCK,
                BRONZE_BLOCK,
                COPPER_BLOCK,
                COPPER_ORE,
                ELECTRUM_BLOCK,
                PEWTER_BLOCK,
                STEEL_BLOCK,
                TIN_BLOCK,
                TIN_ORE,
                ZINC_BLOCK,
                ZINC_ORE
        );
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemBlock(BRASS_BLOCK).setRegistryName(BRASS_BLOCK.getRegistryName()),
                new ItemBlock(BRONZE_BLOCK).setRegistryName(BRONZE_BLOCK.getRegistryName()),
                new ItemBlock(COPPER_BLOCK).setRegistryName(COPPER_BLOCK.getRegistryName()),
                new ItemBlock(COPPER_ORE).setRegistryName(COPPER_ORE.getRegistryName()),
                new ItemBlock(ELECTRUM_BLOCK).setRegistryName(ELECTRUM_BLOCK.getRegistryName()),
                new ItemBlock(PEWTER_BLOCK).setRegistryName(PEWTER_BLOCK.getRegistryName()),
                new ItemBlock(STEEL_BLOCK).setRegistryName(STEEL_BLOCK.getRegistryName()),
                new ItemBlock(TIN_BLOCK).setRegistryName(TIN_BLOCK.getRegistryName()),
                new ItemBlock(TIN_ORE).setRegistryName(TIN_ORE.getRegistryName()),
                new ItemBlock(ZINC_BLOCK).setRegistryName(ZINC_BLOCK.getRegistryName()),
                new ItemBlock(ZINC_ORE).setRegistryName(ZINC_ORE.getRegistryName())
        );
    }
}
