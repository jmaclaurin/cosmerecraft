package com.mistcraft.common.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class MetalReserveProvider implements ICapabilitySerializable<NBTBase>{
    @CapabilityInject(IMetalReserve.class)
    public static final Capability<IMetalReserve> TEST_METAL_RESERVE = null;
    private IMetalReserve instance = TEST_METAL_RESERVE.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == TEST_METAL_RESERVE;
    }

    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == TEST_METAL_RESERVE ? TEST_METAL_RESERVE.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return TEST_METAL_RESERVE.getStorage().writeNBT(TEST_METAL_RESERVE, this.instance, null);
    }

    public void deserializeNBT(NBTBase nbt) {
        TEST_METAL_RESERVE.getStorage().readNBT(TEST_METAL_RESERVE, this.instance, null, nbt);
    }
}
