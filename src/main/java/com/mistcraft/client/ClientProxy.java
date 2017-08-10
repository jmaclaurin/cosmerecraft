package com.mistcraft.client;

import com.mistcraft.common.IProxy;
import com.mistcraft.common.block.ModBlocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements IProxy {
    public void preInit(FMLPreInitializationEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.COPPER_ORE),
                ModBlocks.COPPER_ORE.getMetaFromState(ModBlocks.COPPER_ORE.getDefaultState()),
                new ModelResourceLocation(ModBlocks.COPPER_ORE.getRegistryName(), "normal"));
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
