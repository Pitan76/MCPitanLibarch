package ml.pkom.mcpitanlibarch.api.event.block.result;

import net.minecraft.block.BlockState;

public class BlockBreakResult {
    public BlockState state;

    public BlockBreakResult(BlockState state) {
        this.state = state;
    }

    public BlockState getState() {
        return state;
    }
}
