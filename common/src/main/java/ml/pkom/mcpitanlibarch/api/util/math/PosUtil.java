package ml.pkom.mcpitanlibarch.api.util.math;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;

public class PosUtil {
    public BlockPos flooredBlockPos(double x, double y, double z) {
        return BlockPos.ofFloored(x, y, z);
    }

    public BlockPos flooredBlockPos(Position pos) {
        return BlockPos.ofFloored(pos);
    }
}
