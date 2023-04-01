package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntityTypeUtil {
    public static Identifier toID(BlockEntityType<?> entityType) {
        return Registry.BLOCK_ENTITY_TYPE.getId(entityType);
    }

    public static BlockEntityType<?> fromId(Identifier identifier) {
        return Registry.BLOCK_ENTITY_TYPE.get(identifier);
    }

    public static int getRawId(BlockEntityType<?> type) {
        return Registry.BLOCK_ENTITY_TYPE.getRawId(type);
    }
}
