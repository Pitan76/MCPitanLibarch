package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.Random;
import org.joml.Quaternionf;

public class MathUtil {

    public static Random createRandom(long seed) {
        return Random.create(seed);
    }

    public static Random createRandom() {
        return Random.create();
    }

    @Deprecated
    public static Quaternionf getRotationDegrees(RotationAxisType type, float deg) {
        return type.axis.rotationDegrees(deg);
    }

    public static class RotationAxisType {

        public static RotationAxisType POSITIVE_X = new RotationAxisType(RotationAxis.POSITIVE_X);
        public static RotationAxisType POSITIVE_Y = new RotationAxisType(RotationAxis.POSITIVE_Y);
        public static RotationAxisType POSITIVE_Z = new RotationAxisType(RotationAxis.POSITIVE_Z);

        protected final RotationAxis axis;
        protected RotationAxisType(RotationAxis axis) {
            this.axis = axis;
        }
    }
}
