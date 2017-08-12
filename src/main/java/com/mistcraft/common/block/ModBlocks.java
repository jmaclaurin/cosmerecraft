package com.mistcraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = com.mistcraft.Mistcraft.MODID)
public final class ModBlocks {
    public static Block COPPER_ORE = new BlockBase("copper_ore");
    public static Block TIN_ORE = new BlockBase("tin_ore");
    public static Block ZINC_ORE = new BlockBase("zinc_ore");

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                COPPER_ORE,
                TIN_ORE,
                ZINC_ORE
        );
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemBlock(COPPER_ORE).setRegistryName(COPPER_ORE.getRegistryName()),
                new ItemBlock(TIN_ORE).setRegistryName(TIN_ORE.getRegistryName()),
                new ItemBlock(ZINC_ORE).setRegistryName(ZINC_ORE.getRegistryName())
        );
    }
}
