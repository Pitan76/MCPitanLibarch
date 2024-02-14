package net.pitan76.mcpitanlib.api.util.v2;

import ml.pkom.mcpitanlibarch.api.tag.TagKey;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.util.BlockUtil;

import java.util.ArrayList;
import java.util.List;

public class BlockUtilV2 {
    /**
     * Check if the block is in the tag. (MCPitanLib TagKey)
     * @param block Block to check.
     * @param tagKey TagKey of the tag.
     * @return If the block is in the tag.
     */
    public static boolean isIn(Block block, TagKey<Block> tagKey) {
        return tagKey.isOf(block);
    }

    /**
     * Check if two blocks are equal.
     * @param block Block to compare.
     * @param block2 Block to compare.
     * @return If two blocks are equal.
     */
    public static boolean isEqual(Block block, Block block2) {
        return block == block2;
    }

    /**
     * Get all blocks in the tag.
     * @param tagKey TagKey of the tag.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(TagKey<Block> tagKey) {
        return getBlocks(tagKey, BlockUtil.getAllBlocks());
    }
    /**
     * Get given the list of blocks in the tag.
     * @param tagKey TagKey of the tag.
     * @param blocks List of blocks to search.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(TagKey<Block> tagKey, List<Block> blocks) {
        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (!BlockUtil.isIn(block, tagKey)) continue;
            result.add(block);
        }
        return result;
    }

    /**
     * Get all blocks in the tag.
     * @param identifier Identifier of the tag.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(Identifier identifier) {
        return getBlocks((TagKey<Block>) TagKey.create(TagKey.Type.BLOCK, identifier));
    }

    /**
     * Get given the list of blocks in the tag.
     * @param identifier Identifier of the tag.
     * @param blocks List of blocks to search.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(Identifier identifier, List<Block> blocks) {
        return getBlocks((TagKey<Block>) TagKey.create(TagKey.Type.BLOCK, identifier), blocks);
    }

    /**
     * Get all blocks in the tag.
     * @param id String of the tag.
     * @return List of blocks in the tag.
     */
    public static List<Block> getBlocks(String id) {
        return getBlocks(new Identifier(id));
    }

    /**
     * Get given the list of blocks in the tag.
     * @param id String of the tag.
     * @param blocks List of blocks to search.
     * @return List of blocks in the tag.
     */

    public static List<Block> getBlocks(String id, List<Block> blocks) {
        return getBlocks(new Identifier(id), blocks);
    }
}
