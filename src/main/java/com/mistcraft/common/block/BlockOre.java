package com.mistcraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

public class BlockOre extends Block {
    public BlockOre(String unlocalizedName, Material material, float hardness, float resistance) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(com.mistcraft.Mistcraft.MODID, unlocalizedName));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public BlockOre(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.ROCK, hardness, resistance);
    }

    public BlockOre(String unlocalizedName) {
        this(unlocalizedName, 2.0F, 10.0F);
    }
}
