package ml.pkom.mcpitanlibarch.api.tile;

import ml.pkom.mcpitanlibarch.api.event.tile.TileTickEvent;
import net.minecraft.block.entity.BlockEntity;

public interface ExtendBlockEntityTicker<T extends BlockEntity> {
    void tick(TileTickEvent event);
}
