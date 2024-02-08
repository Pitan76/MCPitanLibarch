package ml.pkom.mcpitanlibarch.api.event.block;

import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StateReplacedEvent extends BaseEvent {

    public BlockState state;
    public World world;
    public BlockPos pos;
    public BlockState newState;
    public boolean moved;

    public StateReplacedEvent(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        super();
    }

    public BlockState getState() {
        return state;
    }

    public World getWorld() {
        return world;
    }

    public BlockPos getPos() {
        return pos;
    }

    public BlockState getNewState() {
        return newState;
    }

    public boolean isMoved() {
        return moved;
    }

    public boolean isClient() {
        return world.isClient();
    }
}
