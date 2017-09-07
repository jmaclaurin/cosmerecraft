package com.mistcraft.common.vial;

import com.mistcraft.common.util.AllomanticMetal;
import jline.internal.Nullable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;

public class VialType extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<VialType> {
    public static final RegistryNamespacedDefaultedByKey<ResourceLocation, VialType> REGISTRY =
            net.minecraftforge.registries.GameData.getWrapperDefaulted(VialType.class);
    public static final int VIAL_STRENGTH = 500;
    public static int nextVialTypeId;
    private final String baseName;
    private int strength;
    private AllomanticMetal metal;

    public VialType(@Nullable String name, AllomanticMetal metal, int stength) {
        this.baseName = name;
        this.metal = metal;
        this.strength = stength;
    }

    public VialType(AllomanticMetal metal, int strength) {
        this(null, metal, strength);
    }

    @Nullable
    public static VialType getVialTypeForName(String name) {
        return REGISTRY.getObject(new ResourceLocation(name));
    }

    public String getName() {
        return this.baseName == null ? ((ResourceLocation)REGISTRY.getNameForObject(this)).getResourcePath() :
                this.baseName;
    }

    public AllomanticMetal getMetal() {
        return metal;
    }

    public int getStrength() {
        return this.strength;
    }

    protected static void registerVialType(String name, VialType vialType) {
        REGISTRY.register(nextVialTypeId++, new ResourceLocation(name), vialType);
    }

    public static void registerVialTypes() {
        registerVialType("empty", new VialType(null, 0));
        for(AllomanticMetal metal : AllomanticMetal.values()) {
            registerVialType(metal.name().toLowerCase(), new VialType(metal, VIAL_STRENGTH));
        }
        REGISTRY.validateKey();
    }
}
