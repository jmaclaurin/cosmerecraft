package com.mistcraft.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityAllomanticLine extends Entity {
    private EntityPlayer allomancer;

    @SideOnly(Side.CLIENT)
    public EntityAllomanticLine(World worldIn, EntityPlayer allomancerIn, double x, double y, double z) {
        super(worldIn);
        this.allomancer = allomancerIn;
        this.setPosition(x, y, z);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
    }

    public EntityFishHook(World worldIn, EntityPlayer allomancerIn)
    {
        this(worldIn, allomancerIn, 0.5F, 0.5F, 0.5F);

    }

    @Override
    protected void entityInit() {}

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {}

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {}

    public EntityPlayer getAllomancer() {
        return allomancer;
    }

    @Override
    public void onUpdate() {
//        if (this.angler == null)
//        {
//            this.setDead();
//        }
//        else if (this.world.isRemote || !this.shouldStopFishing())
//        {
//            if (this.inGround)
//            {
//                ++this.ticksInGround;
//
//                if (this.ticksInGround >= 1200)
//                {
//                    this.setDead();
//                    return;
//                }
//            }
//
//            float f = 0.0F;
//            BlockPos blockpos = new BlockPos(this);
//            IBlockState iblockstate = this.world.getBlockState(blockpos);
//
//            if (iblockstate.getMaterial() == Material.WATER)
//            {
//                f = BlockLiquid.getBlockLiquidHeight(iblockstate, this.world, blockpos);
//            }
//
//            if (this.currentState == EntityFishHook.State.FLYING)
//            {
//                if (this.caughtEntity != null)
//                {
//                    this.motionX = 0.0D;
//                    this.motionY = 0.0D;
//                    this.motionZ = 0.0D;
//                    this.currentState = EntityFishHook.State.HOOKED_IN_ENTITY;
//                    return;
//                }
//
//                if (f > 0.0F)
//                {
//                    this.motionX *= 0.3D;
//                    this.motionY *= 0.2D;
//                    this.motionZ *= 0.3D;
//                    this.currentState = EntityFishHook.State.BOBBING;
//                    return;
//                }
//
//                if (!this.world.isRemote)
//                {
//                    this.checkCollision();
//                }
//
//                if (!this.inGround && !this.onGround && !this.isCollidedHorizontally)
//                {
//                    ++this.ticksInAir;
//                }
//                else
//                {
//                    this.ticksInAir = 0;
//                    this.motionX = 0.0D;
//                    this.motionY = 0.0D;
//                    this.motionZ = 0.0D;
//                }
//            }
//            else
//            {
//                if (this.currentState == EntityFishHook.State.HOOKED_IN_ENTITY)
//                {
//                    if (this.caughtEntity != null)
//                    {
//                        if (this.caughtEntity.isDead)
//                        {
//                            this.caughtEntity = null;
//                            this.currentState = EntityFishHook.State.FLYING;
//                        }
//                        else
//                        {
//                            this.posX = this.caughtEntity.posX;
//                            double d2 = (double)this.caughtEntity.height;
//                            this.posY = this.caughtEntity.getEntityBoundingBox().minY + d2 * 0.8D;
//                            this.posZ = this.caughtEntity.posZ;
//                            this.setPosition(this.posX, this.posY, this.posZ);
//                        }
//                    }
//
//                    return;
//                }
//
//                if (this.currentState == EntityFishHook.State.BOBBING)
//                {
//                    this.motionX *= 0.9D;
//                    this.motionZ *= 0.9D;
//                    double d0 = this.posY + this.motionY - (double)blockpos.getY() - (double)f;
//
//                    if (Math.abs(d0) < 0.01D)
//                    {
//                        d0 += Math.signum(d0) * 0.1D;
//                    }
//
//                    this.motionY -= d0 * (double)this.rand.nextFloat() * 0.2D;
//
//                    if (!this.world.isRemote && f > 0.0F)
//                    {
//                        this.catchingFish(blockpos);
//                    }
//                }
//            }
//
//            if (iblockstate.getMaterial() != Material.WATER)
//            {
//                this.motionY -= 0.03D;
//            }
//
//            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
//            this.updateRotation();
//            double d1 = 0.92D;
//            this.motionX *= 0.92D;
//            this.motionY *= 0.92D;
//            this.motionZ *= 0.92D;
//            this.setPosition(this.posX, this.posY, this.posZ);
//        }
        super.onUpdate();
    }
}
