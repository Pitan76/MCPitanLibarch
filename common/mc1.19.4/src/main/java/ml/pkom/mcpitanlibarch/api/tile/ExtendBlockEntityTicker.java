package ml.pkom.mcpitanlibarch.api.tile;

import ml.pkom.mcpitanlibarch.api.event.tile.TileTickEvent;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ExtendBlockEntityTicker<T extends BlockEntity> extends BlockEntityTicker<T> {
    @Override
    default void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        tick(new TileTickEvent(world, pos, state, blockEntity));
    }

    void tick(TileTickEvent event);
}
