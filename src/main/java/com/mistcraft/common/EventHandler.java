package com.mistcraft.common;

import com.mistcraft.Mistcraft;
import com.mistcraft.common.util.AllomanticMetal;
import com.mistcraft.common.capability.allomanticreserve.AllomanticReserveProvider;
import com.mistcraft.common.capability.allomanticreserve.IAllomanticReserve;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

@Mod.EventBusSubscriber(modid = Mistcraft.MODID)
public class EventHandler {
    @SubscribeEvent
    public static void onPlayerLogsIn(PlayerLoggedInEvent event){
        EntityPlayer player = event.player;
        IAllomanticReserve allomanticReserve = player.getCapability(AllomanticReserveProvider.ALLOMANTIC_RESERVES, null);

        String message = "YOUR ALLOMANTIC RESERVES\n===================================\n";
        for(AllomanticMetal metal : AllomanticMetal.values()) {
            message += metal.name() + " : " + allomanticReserve.getMetalReserve(metal) + "\n";
        }

        player.sendMessage(new TextComponentString(message));
    }
}
