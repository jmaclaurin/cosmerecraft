package com.mistcraft.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFile extends ItemBase {
    public ItemFile(String unlocalizedName) {
        super(unlocalizedName, 1);
        this.setMaxDamage(20);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        for(EnumFileType fileType : EnumFileType.values()) {
            ItemStack stack = new ItemStack(this, 1, fileType.ordinal());
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("itemDamage", 0);
            //fileType.getDurability()
            stack.setTagCompound(nbt);
            items.add(stack);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "." + EnumFileType.values()[stack.getMetadata()].getUnlocalizedName();
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setItemDamage(stack.getItemDamage() + 1);
        return stack;
    }

    @Override
    public int getDamage(ItemStack stack) {
        return stack.getTagCompound().getInteger("itemDamage");
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return stack.getTagCompound().getInteger("itemDamage") > 0;
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        if(damage < 0) {
            stack.getTagCompound().setInteger("itemDamage", 0);
        } else {
            stack.getTagCompound().setInteger("itemDamage", damage);
        }
    }
}
