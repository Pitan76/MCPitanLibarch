package ml.pkom.mcpitanlibarch.api.util.math;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;

public class PosUtil {
    public static BlockPos flooredBlockPos(double x, double y, double z) {
        return BlockPos.ofFloored(x, y, z);
    }

    public static BlockPos flooredBlockPos(Position pos) {
        return BlockPos.ofFloored(pos);
    }
    public static BlockPos flooredBlockPos(Vec3d pos) {
        return BlockPos.ofFloored(pos);
    }

    public static double getSquaredDistance(BlockPos pos1, BlockPos pos2) {
        return pos1.getSquaredDistance(pos2);
    }

    public static double getSquaredDistance(BlockPos pos1, double x, double y, double z) {
        return pos1.getSquaredDistance(x, y, z);
    }
}
