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
    public static Item TIN_INGOT = new ItemBase("tin_ingot");
    public static Item TIN_NUGGET = new ItemBase("tin_nugget");
    public static Item ZINC_INGOT = new ItemBase("zinc_ingot");
    public static Item ZINC_NUGGET = new ItemBase("zinc_nugget");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                COPPER_INGOT,
                COPPER_NUGGET,
                TIN_INGOT,
                TIN_NUGGET,
                ZINC_INGOT,
                ZINC_NUGGET
        );
    }
}
