package com.mistcraft.common.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class MetalReserveStorage implements Capability.IStorage<IMetalReserve>{
    @Override
    public NBTBase writeNBT(Capability<IMetalReserve> capability, IMetalReserve instance, EnumFacing side) {
        return new NBTTagFloat(instance.getMetalReserve());
    }

    @Override
    public void readNBT(Capability<IMetalReserve> capability, IMetalReserve instance, EnumFacing side, NBTBase nbt) {
        instance.setMetalReserve(((NBTPrimitive) nbt).getFloat());
    }
}
