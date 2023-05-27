package ml.pkom.mcpitanlibarch.api.event.block;

import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class OutlineShapeEvent extends BaseEvent {
    public BlockState state;
    public BlockView world;
    public BlockPos pos;
    public ShapeContext context;

    public OutlineShapeEvent(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        this.state = state;
        this.world = world;
        this.pos = pos;
        this.context = context;
    }

    public BlockPos getPos() {
        return pos;
    }

    public BlockState getState() {
        return state;
    }

    public BlockView getWorld() {
        return world;
    }

    public ShapeContext getContext() {
        return context;
    }
}
