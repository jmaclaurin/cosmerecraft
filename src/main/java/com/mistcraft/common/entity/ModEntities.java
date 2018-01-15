package com.mistcraft.common.entity;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber(modid = com.mistcraft.Mistcraft.MODID)
public class ModEntities {
    public static EntityEntry ALLOMANTIC_LINE = new EntityEntry(EntityAllomanticLine.class, "allomantic_line");

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().register(ALLOMANTIC_LINE);
    }
}
