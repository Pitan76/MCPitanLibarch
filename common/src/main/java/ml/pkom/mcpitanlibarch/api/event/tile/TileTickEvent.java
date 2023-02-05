package ml.pkom.mcpitanlibarch.api.event.tile;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileTickEvent {
    public World world;
    public BlockPos pos;
    public BlockState state;
    public BlockEntity blockEntity;

    public TileTickEvent(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        this.world = world;
        this.pos = pos;
        this.state = state;
        this.blockEntity = blockEntity;
    }
}
