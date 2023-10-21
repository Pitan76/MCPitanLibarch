package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.world.World;

public class WorldRandomUtil {
    public static int nextInt(World world) {
        return world.getRandom().nextInt();
    }

    public static int nextInt(World world, int bound) {
        return world.getRandom().nextInt(bound);
    }

    public static long nextLong(World world) {
        return world.getRandom().nextLong();
    }

    public static double nextDouble(World world) {
        return world.getRandom().nextDouble();
    }

    public static double nextGaussian(World world) {
        return world.getRandom().nextGaussian();
    }

    public static float nextFloat(World world) {
        return world.getRandom().nextFloat();
    }

    public static int nextBetween(World world, int min, int max) {
        return world.getRandom().nextBetween(min, max);
    }

    public static int nextBetweenExclusive(World world, int min, int max) {
        return world.getRandom().nextBetweenExclusive(min, max);
    }
}
