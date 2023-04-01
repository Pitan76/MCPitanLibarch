package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityTypeUtil {
    public static Identifier toID(EntityType<?> entityType) {
        return Registry.ENTITY_TYPE.getId(entityType);
    }

    public static EntityType<?> fromId(Identifier identifier) {
        return Registry.ENTITY_TYPE.get(identifier);
    }

    public static int getRawId(EntityType<?> type) {
        return Registry.ENTITY_TYPE.getRawId(type);
    }
}
