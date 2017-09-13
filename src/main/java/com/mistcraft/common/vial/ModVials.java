package com.mistcraft.common.vial;

import com.mistcraft.common.util.AllomanticMetal;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModVials {
    public static final Map<String, Vial> VIAL_MAP = new LinkedHashMap<>();

    // TODO: init individual public static Vial for each vial type.

    public static Vial getVialFromKey(String key) {
        if(VIAL_MAP.containsKey(key)) {
            return VIAL_MAP.get(key);
        } else if(VIAL_MAP.containsKey("empty")) {
            return VIAL_MAP.get("empty");
        }
        return null;
    }

    public static Vial registerVial(Vial vial) {
        VIAL_MAP.put(vial.getKey(), vial);
        return vial;
    }

    public static void registerVials() {
        for(AllomanticMetal metal : AllomanticMetal.values()) {
            String metalName = metal.name().toLowerCase();
            registerVial(new Vial(metalName, metal, 50));
        }
    }
}
