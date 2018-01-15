package com.mistcraft.common;

import com.mistcraft.common.capability.allomanticreserve.AllomanticReserve;
import com.mistcraft.common.capability.allomanticreserve.AllomanticReserveStorage;
import com.mistcraft.common.capability.allomanticreserve.IAllomanticReserve;
import com.mistcraft.world.gen.ModWorldGenerator;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new ModWorldGenerator(), 0);
        CapabilityManager.INSTANCE.register(IAllomanticReserve.class, new AllomanticReserveStorage(),
                AllomanticReserve.class);
//        ModRecipes.registerSmeltingRecipes();
    }

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {}
}