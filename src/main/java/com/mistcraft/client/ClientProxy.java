package com.mistcraft.client;

import com.mistcraft.common.CommonProxy;
import com.mistcraft.common.item.ItemVial;
import com.mistcraft.common.item.ModItems;
import com.mistcraft.common.vial.Vial;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid=com.mistcraft.Mistcraft.MODID, value=Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);

        // Register Item Color Handlers
        ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
        itemColors.registerItemColorHandler((s, t) -> {
            if(t != 1) {
                return -1;
            }
            Vial vial = (((ItemVial)s.getItem()).getVial(s));
            return vial.getMetal().color();
        }, ModItems.VIAL);
    }

    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
