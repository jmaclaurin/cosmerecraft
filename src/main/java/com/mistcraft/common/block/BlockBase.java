package com.mistcraft.common.block;

import com.mistcraft.common.MistcraftCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block {
    public BlockBase(String unlocalizedName, Material material, float hardness, float resistance) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(com.mistcraft.Mistcraft.MODID, unlocalizedName));
        this.setCreativeTab(MistcraftCreativeTab.INSTANCE);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public BlockBase(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.ROCK, hardness, resistance);
    }

    public BlockBase(String unlocalizedName) {
        this(unlocalizedName, 2.0F, 10.0F);
    }
}
