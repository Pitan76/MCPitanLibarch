package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import ml.pkom.mcpitanlibarch.api.tag.MineableToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

import java.util.List;

@Deprecated
public class BlockUtil {
    private static net.pitan76.mcpitanlib.api.util.BlockUtil newBlockUtil = new net.pitan76.mcpitanlib.api.util.BlockUtil();
    
    public static Block block(Identifier id) {
        return newBlockUtil.block(id);
    }

    public static AbstractBlock.Settings breakByTool(AbstractBlock.Settings settings, MineableToolTags toolTags, int level) {
        return newBlockUtil.breakByTool(settings, toolTags, level);
    }

    public static AbstractBlock.Settings dropsNothing(AbstractBlock.Settings settings) {
        return newBlockUtil.dropsNothing(settings);
    }

    public static AbstractBlock.Settings requiresTool(AbstractBlock.Settings settings) {
        return newBlockUtil.requiresTool(settings);
    }

    public static boolean isExist(Identifier identifier) {
        return newBlockUtil.isExist(identifier);
    }

    public static Identifier toID(Block block) {
        return newBlockUtil.toID(block);
    }

    public static Block fromId(Identifier identifier) {
        return newBlockUtil.fromId(identifier);
    }

    public static List<Block> getAllBlocks() {
        return newBlockUtil.getAllBlocks();
    }

    @Deprecated
    public static Block of(AbstractBlock.Settings settings) {
        return newBlockUtil.of(settings);
    }

    public static Block of(CompatibleBlockSettings settings) {
        return newBlockUtil.of(settings);
    }

    public static int getRawId(Block block) {
        return newBlockUtil.getRawId(block);
    }

    public static Block fromIndex(int index) {
        return newBlockUtil.fromIndex(index);
    }
}
