package com.mistcraft.common.capability.allomanticreserve;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class AllomanticReserveProvider implements ICapabilitySerializable<NBTBase>{
    @CapabilityInject(IAllomanticReserve.class)
    public static final Capability<IAllomanticReserve> ALLOMANTIC_RESERVES = null;
    private IAllomanticReserve instance = ALLOMANTIC_RESERVES.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == ALLOMANTIC_RESERVES;
    }

    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == ALLOMANTIC_RESERVES ? ALLOMANTIC_RESERVES.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return ALLOMANTIC_RESERVES.getStorage().writeNBT(ALLOMANTIC_RESERVES, this.instance, null);
    }

    public void deserializeNBT(NBTBase nbt) {
        ALLOMANTIC_RESERVES.getStorage().readNBT(ALLOMANTIC_RESERVES, this.instance, null, nbt);
    }
}
