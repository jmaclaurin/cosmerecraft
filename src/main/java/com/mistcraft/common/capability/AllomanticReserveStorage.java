package com.mistcraft.common.capability;

import com.mistcraft.common.util.AllomanticMetal;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class AllomanticReserveStorage implements Capability.IStorage<IAllomanticReserve>{
    @Override
    public NBTBase writeNBT(Capability<IAllomanticReserve> capability, IAllomanticReserve instance, EnumFacing side) {
        NBTTagCompound tagCompound = new NBTTagCompound();
        for(AllomanticMetal metal : AllomanticMetal.values()) {
            tagCompound.setFloat(metal.name(), instance.getMetalReserve(metal));
        }
        return tagCompound;
    }

    @Override
    public void readNBT(Capability<IAllomanticReserve> capability, IAllomanticReserve instance, EnumFacing side, NBTBase nbt) {
        for(AllomanticMetal metal : AllomanticMetal.values()) {
            instance.setMetalReserve(metal, ((NBTTagCompound)nbt).getFloat(metal.name()));
        }
    }
}
