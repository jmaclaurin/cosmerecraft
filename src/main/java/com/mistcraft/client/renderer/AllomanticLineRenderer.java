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
    private static final int ALLOMANTIC_RANGE = 8;
    private static final int ALLOMANTIC_RANGE_FLARING = 16;
    private static final Block[] ALLOMANTIC_BLOCKS = {
//            Blocks.GOLD_BLOCK,
//            Blocks.GOLD_ORE,
//            Blocks.GOLDEN_RAIL,
//            Blocks.IRON_BARS,
            Blocks.IRON_BLOCK,
//            Blocks.IRON_DOOR,
//            Blocks.IRON_ORE,
//            Blocks.IRON_TRAPDOOR
    };

    public static List<BlockPos> getMetalsInRange() {
        //TODO: Flood fill groups of blocks. Single allomantic line
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
        GlStateManager.disableCull();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();

        double playerYaw = Math.toRadians(interpolateValue(player.prevRotationYaw, player.rotationYaw, event.getPartialTicks()));

        double p0x = Math.sin(playerYaw) * -0.2D;
        double p0y = 1D;
        double p0z = Math.cos(playerYaw) * 0.2;

        for(BlockPos metalPos : getMetalsInRange()) {
            double p2x = metalPos.getX() - interpolateValue(player.prevPosX, player.posX, event.getPartialTicks()) + 0.5;
            double p2y = metalPos.getY() - interpolateValue(player.prevPosY, player.posY, event.getPartialTicks()) + 0.5;
            double p2z = metalPos.getZ() - interpolateValue(player.prevPosZ, player.posZ, event.getPartialTicks()) + 0.5;

            double p1x = p2x + ((p0x - p2x) / 2);
            double p1y = p2y + ((p0y - p2y) / 2) - 0.5D;
            double p1z = p2z + ((p0z - p2z) / 2);

            double[] q0 = offsetVector(p0x, p0y, p0z);
            double[] q1 = offsetVector(p1x, p1y, p1z);
            double[] q2 = offsetVector(p2x, p2y, p2z);

            bufferBuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
            for(int k = 0; k <= 24; k++) {
                double t = k/24D;
                bufferBuilder.pos((Math.pow(1 - t, 2) * p0x) + ((2 * (1 - t)) * t * p1x) + (Math.pow(t, 2) * p2x),
                        (Math.pow(1 - t, 2) * p0y) + ((2 * (1 - t)) * t * p1y) + (Math.pow(t, 2) * p2y),
                        (Math.pow(1 - t, 2) * p0z) + ((2 * (1 - t)) * t * p1z) + (Math.pow(t, 2) * p2z)
                ).color(0, 0, 255, 255).endVertex();

                bufferBuilder.pos((Math.pow(1 - t, 2) * q0[0]) + ((2 * (1 - t)) * t * q1[0]) + (Math.pow(t, 2) * q2[0]),
                        (Math.pow(1 - t, 2) * q0[1]) + ((2 * (1 - t)) * t * q1[1]) + (Math.pow(t, 2) * q2[1]),
                        (Math.pow(1 - t, 2) * q0[2]) + ((2 * (1 - t)) * t * q1[2]) + (Math.pow(t, 2) * q2[2])
                ).color(0, 0, 255, 255).endVertex();
            }
            tessellator.draw();
        }

        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    private static double[] offsetVector(double x, double y, double z) {
        double rx = 1D;
        double rz = -z/x;

        if(z == 0D) {
            rx = 1D;
        }
        if(x == 0D) {
            rz = 1D;
        }

        rx = x - ((rx / (Math.sqrt(Math.pow(rx, 2) + Math.pow(rz, 2)))) * 0.04D);
        rz = z - ((rz / (Math.sqrt(Math.pow(rx, 2) + Math.pow(rz, 2)))) * 0.04D);

         return new double[]{rx, y, rz};
    }

    private static double interpolateValue(double start, double end, double pct) {
        return start + (end - start) * pct;
    }
}