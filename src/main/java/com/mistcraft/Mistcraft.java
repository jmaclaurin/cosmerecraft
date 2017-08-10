package com.mistcraft;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


@Mod(modid = com.mistcraft.Mistcraft.MODID, version = com.mistcraft.Mistcraft.VERSION)
@Mod.EventBusSubscriber
public class Mistcraft
{
    public static final String MODID = "mistcraft";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+ Blocks.DIRT.getUnlocalizedName());
    }

    @Mod.EventHandler
    public void preInit(FMLInitializationEvent event) {

    }
}
