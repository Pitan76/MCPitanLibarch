package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidUtil {
    public static Identifier toID(Fluid fluid) {
        return Registry.FLUID.getId(fluid);
    }

    public static Fluid fromId(Identifier identifier) {
        return Registry.FLUID.get(identifier);
    }
}
