package ml.pkom.mcpitanlibarch.api.block;

import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public interface ExtendBlockEntityProvider extends BlockEntityProvider {
    @Nullable
    @Override
    default BlockEntity createBlockEntity(BlockView world) {
        return createBlockEntity(new TileCreateEvent(world));
    }

    @Nullable
    default BlockEntity createBlockEntity(TileCreateEvent event) {
        if (getBlockEntityType() == null) return null;

        // return new ...BlockEntity(world)
        return getBlockEntityType().instantiate();
    }

    @Nullable
    default <T extends BlockEntity> BlockEntityType<T> getBlockEntityType() {
        return null;
    }

    default boolean isTick() {
        return false;
    }
}
