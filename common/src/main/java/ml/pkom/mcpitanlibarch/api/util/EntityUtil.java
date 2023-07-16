package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class EntityUtil {
    public static World getWorld(Entity entity) {
        return entity.getEntityWorld();
    }
}
