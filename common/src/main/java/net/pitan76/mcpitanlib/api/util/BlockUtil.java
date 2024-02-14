package net.pitan76.mcpitanlib.api.util;

import ml.pkom.mcpitanlibarch.api.block.CompatibleBlockSettings;
import ml.pkom.mcpitanlibarch.api.tag.MineableToolTags;
import ml.pkom.mcpitanlibarch.api.tag.TagKey;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.util.v1.BlockUtilV1;
import net.pitan76.mcpitanlib.api.util.v2.BlockUtilV2;

import java.util.List;

public class BlockUtil {
    /**
     * Get block from Identifier.
     * @param id Identifier of the block.
     * @return Block of the Identifier.
     */
    public static Block block(Identifier id) {
        return BlockUtilV1.block(id);
    }

    /**
     * Check if two blocks are equal.
     * @param block Block to compare.
     * @param block2 Block to compare.
     * @return If two blocks are equal.
     */
    public static boolean isEqual(Block block, Block block2) {
        return BlockUtilV2.isEqual(block, block2);
    }

    /**
     * Check if the block is in the tag. (MCPitanLib TagKey)
     * @param block Block to check.
     * @param tagKey TagKey of the tag.
     * @return If the block is in the tag.
     */
    public static boolean isIn(Block block, TagKey<Block> tagKey) {
        return BlockUtilV2.isIn(block, tagKey);
    }

    /**
     * set break tool tag and level to block
     * @param settings Block settings
     * @param toolTags Tool tags
     * @param level Level
     * @return Block settings
     */
    public static AbstractBlock.Settings breakByTool(AbstractBlock.Settings settings, MineableToolTags toolTags, int level) {
        return BlockUtilV1.breakByTool(settings, toolTags, level);
    }

    /**
     * not drop anything when block is broken
     * @param settings Block settings
     * @return Block settings
     */
    public static AbstractBlock.Settings dropsNothing(AbstractBlock.Settings settings) {
        return BlockUtilV1.dropsNothing(settings);
    }
    /**
     * block breaking requires any tool
     * @param settings Block settings
     * @return Block settings
     */
    public static AbstractBlock.Settings requiresTool(AbstractBlock.Settings settings) {
        return BlockUtilV1.requiresTool(settings);
    }

    /**
     * Check if the block is existed.
     * @param identifier Identifier of the block.
     * @return If the block is existed.
     */
    public static boolean isExist(Identifier identifier) {
        return BlockUtilV1.isExist(identifier);
    }

    /**
     * Get Identifier from block.
     * @param block Block to get Identifier.
     * @return Identifier of the block.
     */
    public static Identifier toID(Block block) {
        return BlockUtilV1.toID(block);
    }

    /**
     * Get block from Identifier.
     * @param identifier Identifier of the block.
     * @return Block of the Identifier.
     */
    public static Block fromId(Identifier identifier) {
        return BlockUtilV1.fromId(identifier);
    }

    /**
     * Get all blocks.
     * @return List of all blocks.
     */
    public static List<Block> getAllBlocks() {
        return BlockUtilV1.getAllBlocks();
    }

    /**
     * Create Block from Block.Settings.
     * @param settings Block.Settings to create Block.
     * @return Block created from Block.Settings.
     */
    @Deprecated
    public static Block of(AbstractBlock.Settings settings) {
        return BlockUtilV1.of(settings);
    }

    /**
     * Create Block from CompatibleBlockSettings.
     * @param settings CompatibleBlockSettings to create Block.
     * @return Block created from CompatibleBlockSettings.
     */
    public static Block of(CompatibleBlockSettings settings) {
        return BlockUtilV1.of(settings);
    }

    /**
     * Get raw id of the block.
     * @param block Block to get raw id.
     * @return Raw id of the block.
     */
    public static int getRawId(Block block) {
        return BlockUtilV1.getRawId(block);
    }

    /**
     * Get block from raw id.
     * @param index Raw id of the block.
     * @return Block from raw id.
     */
    public static Block fromIndex(int index) {
        return BlockUtilV1.fromIndex(index);
    }

    /**
     * Get all blocks in the tag. (MCPitanLib TagKey)
     * @param tagKey TagKey of the tag.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(TagKey<Block> tagKey) {
        return BlockUtilV2.getBlocks(tagKey);
    }

    /**
     * Get given the list of blocks in the tag. (MCPitanLib TagKey)
     * @param tagKey TagKey of the tag.
     * @param blocks List of blocks to search.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(TagKey<Block> tagKey, List<Block> blocks) {
        return BlockUtilV2.getBlocks(tagKey, blocks);
    }

    /**
     * Get all blocks in the tag.
     * @param identifier Identifier of the tag.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(Identifier identifier) {
        return BlockUtilV2.getBlocks(identifier);
    }

    /**
     * Get given the list of blocks in the tag.
     * @param identifier Identifier of the tag.
     * @param blocks List of blocks to search.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(Identifier identifier, List<Block> blocks) {
        return BlockUtilV2.getBlocks(identifier, blocks);
    }

    /**
     * Get all blocks in the tag.
     * @param id String of the tag.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(String id) {
        return BlockUtilV2.getBlocks(id);
    }

    /**
     * Get given the list of blocks in the tag.
     * @param id String of the tag.
     * @param blocks List of blocks to search.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(String id, List<Block> blocks) {
        return BlockUtilV2.getBlocks(id, blocks);
    }
}
