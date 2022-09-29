package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.tag.MineableToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockUtil {
    public static Block block(Identifier id) {
        return Registry.BLOCK.get(id);
    }

    /**
     * ～1.16?
     * @param settings
     * @param toolTags
     * @param level
     * @return
     */
    public static AbstractBlock.Settings breakByTool(AbstractBlock.Settings settings, MineableToolTags toolTags, int level) {

        return settings;
    }

    public static AbstractBlock.Settings dropsNothing(AbstractBlock.Settings settings) {
        return settings.dropsNothing();
    }

    public static AbstractBlock.Settings requiresTool(AbstractBlock.Settings settings) {
        return settings.requiresTool();
    }
}
