package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class EntityTypeUtil {
    public static Identifier toID(EntityType<?> entityType) {
        return Registries.ENTITY_TYPE.getId(entityType);
    }

    public static EntityType<?> fromId(Identifier identifier) {
        return Registries.ENTITY_TYPE.get(identifier);
    }

    public static int getRawId(EntityType<?> type) {
        return Registries.ENTITY_TYPE.getRawId(type);
    }
}
