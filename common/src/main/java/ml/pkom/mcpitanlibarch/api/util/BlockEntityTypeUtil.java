package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class BlockEntityTypeUtil {
    public static Identifier toID(BlockEntityType<?> entityType) {
        return Registries.BLOCK_ENTITY_TYPE.getId(entityType);
    }

    public static BlockEntityType<?> fromId(Identifier identifier) {
        return Registries.BLOCK_ENTITY_TYPE.get(identifier);
    }

    public static int getRawId(BlockEntityType<?> type) {
        return Registries.BLOCK_ENTITY_TYPE.getRawId(type);
    }
}
