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

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(COPPER_INGOT);
        event.getRegistry().register(COPPER_NUGGET);
    }
}
