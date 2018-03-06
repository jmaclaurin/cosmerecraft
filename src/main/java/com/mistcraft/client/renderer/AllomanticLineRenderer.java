package com.mistcraft.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid=com.mistcraft.Mistcraft.MODID, value= Side.CLIENT)
public class AllomanticLineRenderer {
    private static final int ALLOMANTIC_RANGE = 10;
    private static final int ALLOMANTIC_RANGE_FLARING = 15;
    private static final Block[] ALLOMANTIC_BLOCKS = {
            Blocks.GOLD_BLOCK,
            Blocks.GOLD_ORE,
            Blocks.GOLDEN_RAIL,
            Blocks.IRON_BARS,
            Blocks.IRON_BLOCK,
            Blocks.IRON_DOOR,
            Blocks.IRON_ORE,
            Blocks.IRON_TRAPDOOR
    };

    public static List<BlockPos> getMetalsInRange() {
        EntityPlayer player = Minecraft.getMinecraft().player;
        List<BlockPos> metalBlocksPositions = new ArrayList<BlockPos>();
        Iterable<BlockPos> blocksInRange = BlockPos.getAllInBox(
                new BlockPos(player.posX + ALLOMANTIC_RANGE, player.posY + ALLOMANTIC_RANGE, player.posZ - ALLOMANTIC_RANGE),
                new BlockPos(player.posX - ALLOMANTIC_RANGE, player.posY - ALLOMANTIC_RANGE, player.posZ + ALLOMANTIC_RANGE));

        for(BlockPos pos : blocksInRange) {
            Block blockAtPos = Minecraft.getMinecraft().world.getBlockState(pos).getBlock();
            if(Arrays.asList(ALLOMANTIC_BLOCKS).contains(blockAtPos)) {
                metalBlocksPositions.add(pos);
            }
        }

        return metalBlocksPositions;
    }

    @SubscribeEvent
    public static void renderWorldLastEvent(RenderWorldLastEvent event) {
        EntityPlayer player = Minecraft.getMinecraft().player;
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder worldRenderer = tessellator.getBuffer();
        worldRenderer.begin(GL11.GL_LINES, DefaultVertexFormats.POSITION_COLOR);

        //TODO: Flood fill groups of blocks. Single allomantic line
        for(BlockPos metalPos : getMetalsInRange()) {
            worldRenderer.pos(0, 1.62, 0).color(0, 0, 255, 160).endVertex();
            worldRenderer.pos(
                    metalPos.getX() + 0.5 - player.posX,
                    metalPos.getY() + 0.5 - player.posY,
                    metalPos.getZ() + 0.5 - player.posZ
            ).color(0, 0, 255, 160).endVertex();
        }

        tessellator.draw();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }
}