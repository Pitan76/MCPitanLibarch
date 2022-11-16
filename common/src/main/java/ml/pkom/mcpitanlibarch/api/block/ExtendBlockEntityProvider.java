package ml.pkom.mcpitanlibarch.api.block;

import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public interface ExtendBlockEntityProvider extends BlockEntityProvider {
    @Nullable
    default BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return createBlockEntity(new TileCreateEvent(pos, state));
    }

    @Nullable
    BlockEntity createBlockEntity(TileCreateEvent event);
}
