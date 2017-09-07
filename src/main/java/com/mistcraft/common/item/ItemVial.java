package com.mistcraft.common.item;

import com.mistcraft.common.MistcraftCreativeTab;
import com.mistcraft.common.vial.VialType;
import com.mistcraft.common.vial.VialUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVial extends Item {
    public ItemVial () {
        super();
        this.setMaxStackSize(8);
        this.setCreativeTab(MistcraftCreativeTab.INSTANCE);
        this.setUnlocalizedName("vial");
        this.setRegistryName(new ResourceLocation(com.mistcraft.Mistcraft.MODID, "vial"));
    }

//    @SideOnly(Side.CLIENT)
//    public ItemStack getDefaultInstance() {
//        return VialUtils.addVialToItemStack(super.getDefaultInstance(), VialType.getVialTypeForName("empty"));
//    }
//
//    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLivingBase) {
//        return null;
//    }
//
//    public int getMaxItemUseDuration(ItemStack stack) {
//        return 32;
//    }
//
//
//    public EnumAction getItemUseAction(ItemStack stack)
//    {
//        return EnumAction.DRINK;
//    }
//
//    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
//        if (this.isInCreativeTab(tab)) {
//            for (VialType vialType : VialType.REGISTRY) {
//                items.add(VialUtils.addVialToItemStack(new ItemStack(this), vialType));
//            }
//        }
//    }
}












//    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
//    {
//        EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;
//
//        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
//        {
//            stack.shrink(1);
//        }
//
//        if (entityplayer instanceof EntityPlayerMP)
//        {
//            CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
//        }
//
//        if (!worldIn.isRemote)
//        {
//            for (PotionEffect potioneffect : PotionUtils.getEffectsFromStack(stack))
//            {
//                if (potioneffect.getPotion().isInstant())
//                {
//                    potioneffect.getPotion().affectEntity(entityplayer, entityplayer, entityLiving, potioneffect.getAmplifier(), 1.0D);
//                }
//                else
//                {
//                    entityLiving.addPotionEffect(new PotionEffect(potioneffect));
//                }
//            }
//        }
//
//        if (entityplayer != null)
//        {
//            entityplayer.addStat(StatList.getObjectUseStats(this));
//        }
//
//        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode)
//        {
//            if (stack.isEmpty())
//            {
//                return new ItemStack(Items.GLASS_BOTTLE);
//            }
//
//            if (entityplayer != null)
//            {
//                entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
//            }
//        }
//
//        return stack;
//    }
//
//    /**
//     * Called when the equipped item is right clicked.
//     */
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
//    {
//        playerIn.setActiveHand(handIn);
//        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
//    }
//
//    public String getItemStackDisplayName(ItemStack stack)
//    {
//        return I18n.translateToLocal(PotionUtils.getPotionFromItem(stack).getNamePrefixed("potion.effect."));
//    }
//
//    /**
//     * allows items to add custom lines of information to the mouseover description
//     */
//    @SideOnly(Side.CLIENT)
//    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
//    {
//        PotionUtils.addPotionTooltip(stack, tooltip, 1.0F);
//    }
//
//    /**
//     * Returns true if this item has an enchantment glint. By default, this returns
//     * <code>stack.isItemEnchanted()</code>, but other items can override it (for instance, written books always return
//     * true).
//     *
//     * Note that if you override this method, you generally want to also call the super version (on {@link Item}) to get
//     * the glint for enchanted items. Of course, that is unnecessary if the overwritten version always returns true.
//     */
//    @SideOnly(Side.CLIENT)
//    public boolean hasEffect(ItemStack stack)
//    {
//        return super.hasEffect(stack) || !PotionUtils.getEffectsFromStack(stack).isEmpty();
//    }
