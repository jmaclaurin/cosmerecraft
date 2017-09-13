package com.mistcraft.common.item;

import com.mistcraft.Mistcraft;
import com.mistcraft.common.capability.AllomanticReserveProvider;
import com.mistcraft.common.vial.ModVials;
import com.mistcraft.common.vial.Vial;
import com.mistcraft.common.vial.VialUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemVial extends ItemBase {
    public ItemVial(String unlocalizedName) {
        super(unlocalizedName, 16);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName() {
        return Mistcraft.MODID + ".vial";
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        player.setActiveHand(hand);
        return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public ItemStack onItemUseFinish(@Nonnull ItemStack stack, World world, EntityLivingBase living) {
        if(!world.isRemote) {
            if(world.rand.nextBoolean()) {
                world.playSound(null, living.posX, living.posY, living.posZ, SoundEvents.ENTITY_PLAYER_BURP,
                        SoundCategory.PLAYERS, 1F, 1F);
            }
            if(living instanceof EntityPlayer && !((EntityPlayer)living).capabilities.isCreativeMode) {
                living.getCapability(AllomanticReserveProvider.ALLOMANTIC_RESERVES, null).fillMetalReserve(
                        getVial(stack).getMetal(), getVial(stack).getStrength());
            }
        }
        stack.shrink(1);
        return stack;
    }

    @Nonnull
    @Override
    public String getItemStackDisplayName(@Nonnull ItemStack stack) {
        return String.format(
                I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name"),
                I18n.translateToLocal(getVial(stack).getUnlocalizedName() + ".name"));
    }

    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if(this.isInCreativeTab(tab)) {
            for (Vial vial : ModVials.VIAL_MAP.values()) {
                ItemStack stack = new ItemStack(this);
                VialUtils.addVialToItemStack(stack, vial);
                list.add(stack);
            }
        }
    }

    public Vial getVial(ItemStack stack) {
        return VialUtils.getVialFromItemStack(stack);
    }
}
