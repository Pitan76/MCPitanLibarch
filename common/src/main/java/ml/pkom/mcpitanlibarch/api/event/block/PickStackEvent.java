package ml.pkom.mcpitanlibarch.api.event.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class PickStackEvent {

    @Deprecated
    public WorldView worldView;

    @Deprecated
    public BlockView blockView;

    public BlockPos pos;
    public BlockState state;


    public PickStackEvent(WorldView world, BlockPos pos, BlockState state) {
    }

    public PickStackEvent(BlockView world, BlockPos pos, BlockState state) {
    }

    public BlockState getState() {
        return state;
    }

    public BlockPos getPos() {
        return pos;
    }

    @Nullable
    public BlockView getBlockView() {
        return blockView;
    }

    @Nullable
    public WorldView getWorldView() {
        return worldView;
    }
}
