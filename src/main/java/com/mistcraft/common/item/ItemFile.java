package com.mistcraft.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFile extends ItemBase {
    public enum EnumFileType {
        IRON("iron_file", 16),
        STEEL("steel_file", 32);

        private final String unlocalizedName;
        private final int durability;

        EnumFileType(String unlocalizedName, int durability) {
            this.unlocalizedName = unlocalizedName;
            this.durability = durability;
        }

        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }

        public int getDurability() {
            return durability;
        }
    }

    public ItemFile(String unlocalizedName, int maxStackSize, int maxDamage) {
        super(unlocalizedName, maxStackSize, maxDamage);
        this.setHasSubtypes(true);
    }

    public ItemFile(String unlocalizedName, int maxStackSize) {
        this(unlocalizedName, maxStackSize, 0);
    }

    public ItemFile(String unlocalizedName) {
        this(unlocalizedName, 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        for(EnumFileType fileType : EnumFileType.values()) {
            ItemStack stack = new ItemStack(this, 1, fileType.ordinal());
            setDamage(stack, 0);
            items.add(stack);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + EnumFileType.values()[stack.getMetadata()].getUnlocalizedName();
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return stack.getItemDamage() < (getMaxDurability(stack) - 1);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setItemDamage(stack.getItemDamage() + 1);
        return stack;
    }

    @Override
    public int getDamage(ItemStack stack) {
        if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("itemDamage")) {
            return stack.getTagCompound().getInteger("itemDamage");
        }
        return 0;
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return stack.getTagCompound() != null && stack.getTagCompound().getInteger("itemDamage") > 0;
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if(tagCompound == null) {
            tagCompound = new NBTTagCompound();
            stack.setTagCompound(tagCompound);
        }

        if(damage < 0) {
            tagCompound.setInteger("itemDamage", 0);
        } else {
            tagCompound.setInteger("itemDamage", damage);
        }
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 0;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return (double)stack.getItemDamage() / (double)getMaxDurability(stack);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return isDamaged(stack);
    }

    public int getMaxDurability(ItemStack stack) {
        return EnumFileType.values()[stack.getMetadata()].getDurability();
    }
}
