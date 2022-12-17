package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldUtil {
    public static boolean hasSkyLight(World world) {
        return world.getDimension().hasSkyLight();
    }

    public static boolean isThundering(World world) {
        return world.isThundering();
    }

    public static boolean isRaining(World world) {
        return world.isRaining();
    }

    public static boolean isNight(World world) {
        return world.isNight();
    }

    public static boolean isDay(World world) {
        return world.isDay();
    }

    public static boolean isSkyVisible(World world, BlockPos pos) {
        return world.isSkyVisible(pos);
    }

    public static boolean isClient(World world) {
        return world.isClient();
    }

    public static void scheduleBlockTick(World world, BlockPos pos, Block block, int delay) {
        world.scheduleBlockTick(pos, block, delay);
    }

    public static void scheduleFluidTick(World world, BlockPos pos, Fluid fluid, int delay) {
        world.scheduleFluidTick(pos, fluid, delay);
    }

    public static boolean isServer(World world) {
        return !isClient(world);
    }

}
