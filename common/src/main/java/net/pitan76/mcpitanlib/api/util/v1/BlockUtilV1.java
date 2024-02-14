package net.pitan76.mcpitanlib.api.util.v1;

import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import ml.pkom.mcpitanlibarch.api.tag.MineableToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class BlockUtilV1 {
    public static Block block(Identifier id) {
        return Registries.BLOCK.get(id);
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

    public static boolean isExist(Identifier identifier) {
        return Registries.BLOCK.containsId(identifier);
    }

    public static Identifier toID(Block block) {
        return Registries.BLOCK.getId(block);
    }

    public static Block fromId(Identifier identifier) {
        return Registries.BLOCK.get(identifier);
    }

    public static List<Block> getAllBlocks() {
        List<Block> blocks = new ArrayList<>();
        for (Block block : Registries.BLOCK) {
            blocks.add(block);
        }
        return blocks;
    }

    @Deprecated
    public static Block of(AbstractBlock.Settings settings) {
        return new Block(settings);
    }

    public static Block of(CompatibleBlockSettings settings) {
        return of(settings.build());
    }

    public static int getRawId(Block block) {
        return Registries.BLOCK.getRawId(block);
    }

    public static Block fromIndex(int index) {
        return Registries.BLOCK.get(index);
    }
}
