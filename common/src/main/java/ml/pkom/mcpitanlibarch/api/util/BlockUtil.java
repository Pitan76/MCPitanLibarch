package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockUtil {
    public static Block block(Identifier id) {
        return Registry.BLOCK.get(id);
    }
}
