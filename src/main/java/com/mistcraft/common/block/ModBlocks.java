package com.mistcraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = com.mistcraft.Mistcraft.MODID)
public final class ModBlocks {
    public static Block COPPER_ORE = new BlockCopperOre();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(COPPER_ORE);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(COPPER_ORE).setRegistryName(COPPER_ORE.getRegistryName()));
    }
}
