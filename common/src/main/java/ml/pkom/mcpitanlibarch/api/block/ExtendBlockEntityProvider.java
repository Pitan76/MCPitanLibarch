package ml.pkom.mcpitanlibarch.api.block;

import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public interface ExtendBlockEntityProvider extends BlockEntityProvider {
    @Nullable
    @Override
    default BlockEntity createBlockEntity(BlockView world) {
        return createBlockEntity(new TileCreateEvent(world));
    }

    @Nullable
    BlockEntity createBlockEntity(TileCreateEvent event);
}
