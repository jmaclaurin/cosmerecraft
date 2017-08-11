package com.mistcraft;

import com.mistcraft.common.IProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = com.mistcraft.Mistcraft.MODID, version = com.mistcraft.Mistcraft.VERSION)
@Mod.EventBusSubscriber
public class Mistcraft {
    public static final String MODID = "mistcraft";
    public static final String VERSION = "1.0";
    public static final String CLEINT_PROXY = "com.mistcraft.client.ClientProxy";
    public static final String SERVER_PROXY = "com.mistcraft.server.ServerProxy";

    @SidedProxy(clientSide=CLEINT_PROXY, serverSide=SERVER_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        System.out.println("DIRT BLOCK >> "+ Blocks.DIRT.getUnlocalizedName());
        proxy.init(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
