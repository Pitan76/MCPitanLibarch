package ml.pkom.mcpitanlibarch.api.tile;

import ml.pkom.mcpitanlibarch.api.event.block.TileCreateEvent;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class ExtendBlockEntity extends BlockEntity {
    public ExtendBlockEntity(BlockEntityType<?> type) {
        super(type);
    }

    public ExtendBlockEntity(BlockEntityType<?> type, TileCreateEvent event) {
        this(type);
    }
}
