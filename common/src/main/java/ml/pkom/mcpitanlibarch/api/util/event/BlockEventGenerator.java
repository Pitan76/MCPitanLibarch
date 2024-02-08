package ml.pkom.mcpitanlibarch.api.util.event;

import ml.pkom.mcpitanlibarch.api.event.block.BlockBreakEvent;
import ml.pkom.mcpitanlibarch.api.event.block.BlockPlacedEvent;
import ml.pkom.mcpitanlibarch.api.event.block.StateReplacedEvent;
import net.minecraft.block.Block;

public class BlockEventGenerator {
    public static void onPlaced(Block block, BlockPlacedEvent e) {
        block.onPlaced(e.world, e.pos, e.state, e.placer, e.stack);
    }

    public static void onBreak(Block block, BlockBreakEvent e) {
        block.onBreak(e.world, e.pos, e.state, e.getPlayerEntity());
    }

    public static void onStateReplaced(Block block, StateReplacedEvent e) {
        block.onStateReplaced(e.state, e.world, e.pos, e.newState, e.moved);
    }
}
