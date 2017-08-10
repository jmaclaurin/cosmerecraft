package com.mistcraft.client;

import com.mistcraft.common.IProxy;
import com.mistcraft.common.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements IProxy {
    public void preInit(FMLPreInitializationEvent event) {
        registerBlockModel(ModBlocks.COPPER_ORE);
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    private void registerBlockModel(Block block, String variant) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                block.getMetaFromState(block.getDefaultState()),
                new ModelResourceLocation(block.getRegistryName(), variant));
    }

    private void registerBlockModel(Block block) {
        registerBlockModel(block, "normal");
    }
}
