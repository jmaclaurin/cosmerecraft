package com.mistcraft.common.vial;

import com.mistcraft.common.util.AllomanticMetal;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class VialUtils {
    public static final String TAG_VIAL_KEY = "vialKey";

    public static AllomanticMetal getMetalFromStack(ItemStack stack) {
        return getMetalFromTag(stack.getTagCompound());
    }

    public static AllomanticMetal getMetalFromTag(NBTTagCompound tagCompound) {
        return getVialFromNBT(tagCompound).getMetal();
    }

    public static int getStrengthFromStack(ItemStack stack) {
        return getStrengthFromTag(stack.getTagCompound());
    }

    public static int getStrengthFromTag(NBTTagCompound tagCompound) {
        return getVialFromNBT(tagCompound).getStrength();
    }

    public static Vial getVialFromNBT(NBTTagCompound tagCompound) {
        return tagCompound.hasKey(TAG_VIAL_KEY) ? ModVials.getVialFromKey(tagCompound.getString(TAG_VIAL_KEY)) :
                Vial.getDefaultInstance();
    }

    public static Vial getVialFromItemStack(ItemStack stack) {
        if(!stack.isEmpty()) {
            if(!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
            }
            return getVialFromNBT(stack.getTagCompound());
        } else {
            return Vial.getDefaultInstance();
        }
    }

    public static ItemStack addVialToItemStack(ItemStack stack, Vial vial) {
        NBTTagCompound tagCompound = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
        tagCompound.setString(TAG_VIAL_KEY, vial.getKey());
        stack.setTagCompound(tagCompound);
        return stack;
    }
}
