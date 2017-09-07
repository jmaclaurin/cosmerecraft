package com.mistcraft.common.vial;

import com.mistcraft.common.util.AllomanticMetal;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class VialUtils {
    public static AllomanticMetal getMetalFromStack(ItemStack stack) {
        return getMetalFromTag(stack.getTagCompound());
    }

    public static int getStrengthFromStack(ItemStack stack) {
        return getStrengthFromTag(stack.getTagCompound());
    }

    public static AllomanticMetal getMetalFromTag(NBTTagCompound tagCompound) {
        return getVialTypeFromNBT(tagCompound).getMetal();
    }

    public static int getStrengthFromTag(NBTTagCompound tagCompound) {
        return getVialTypeFromNBT(tagCompound).getStrength();
    }

//    public static VialType getVialTypeFromNBT(@Nullable NBTTagCompound tagCompound) {
    public static VialType getVialTypeFromNBT(NBTTagCompound tagCompound) {
        //return tag == null ? PotionTypes.EMPTY : PotionType.getPotionTypeForName(tag.getString("Potion"));
        return VialType.getVialTypeForName(tagCompound.getString("Vial"));
    }

    public static int getColor(ItemStack stack) {
        return 3694022;
    }

    public static VialType getVialFromItem(ItemStack stack) {
        return getVialTypeFromNBT(stack.getTagCompound());
    }

    public static ItemStack addVialToItemStack(ItemStack stack, VialType vialType) {
        ResourceLocation resourceLocation = VialType.REGISTRY.getNameForObject(vialType);
        NBTTagCompound tagCompound = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
        tagCompound.setString("Vial", resourceLocation.toString());
        stack.setTagCompound(tagCompound);
        return stack;
    }
}
