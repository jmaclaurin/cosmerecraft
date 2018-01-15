package com.mistcraft.common.capability;

import com.mistcraft.Mistcraft;
import com.mistcraft.common.capability.allomanticreserve.AllomanticReserveProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Mistcraft.MODID)
public class CapabilityHandler {
    public static final ResourceLocation ALLOMANTIC_RESERVES =
            new ResourceLocation(Mistcraft.MODID, "allomantic_reserves");

    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if(!(event.getObject() instanceof EntityPlayer)) {
            return;
        }
        event.addCapability(ALLOMANTIC_RESERVES, new AllomanticReserveProvider());
    }
}
