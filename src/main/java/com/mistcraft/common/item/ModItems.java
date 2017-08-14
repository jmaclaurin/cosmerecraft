package com.mistcraft.common.item;

import com.mistcraft.Mistcraft;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Mistcraft.MODID)
public final class ModItems {
    public static Item COPPER_INGOT = new ItemBase("copper_ingot");
    public static Item COPPER_NUGGET = new ItemBase("copper_nugget");
    public static Item COPPER_SHAVINGS = new ItemBase("copper_shavings");
    public static Item FILE = new ItemFile("file");
    public static Item TIN_INGOT = new ItemBase("tin_ingot");
    public static Item TIN_NUGGET = new ItemBase("tin_nugget");
    public static Item TIN_SHAVINGS = new ItemBase("tin_shavings");
    public static Item ZINC_INGOT = new ItemBase("zinc_ingot");
    public static Item ZINC_NUGGET = new ItemBase("zinc_nugget");
    public static Item ZINC_SHAVINGS = new ItemBase("zinc_shavings");


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                COPPER_INGOT,
                COPPER_NUGGET,
                COPPER_SHAVINGS,
                FILE,
                TIN_INGOT,
                TIN_NUGGET,
                TIN_SHAVINGS,
                ZINC_INGOT,
                ZINC_NUGGET,
                ZINC_SHAVINGS
        );
    }
}
