package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.util.math.random.Random;

public class MathUtil {

    public static Random createRandom(long seed) {
        return Random.create(seed);
    }

    public static Random createRandom() {
        return Random.create();
    }
}
