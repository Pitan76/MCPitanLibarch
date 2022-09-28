package ml.pkom.mcpitanlibarch.api.util;

import java.util.Random;

public class MathUtil {

    public static Random createRandom(long seed) {
        return new Random(seed);
    }

    public static Random createRandom() {
        return new Random();
    }
}
