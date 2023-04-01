package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.math.random.Random;

public class MathUtil {

    public static Random createRandom(long seed) {
        return Random.create(seed);
    }

    public static Random createRandom() {
        return Random.create();
    }

    public static Quaternion getRotationDegrees(RotationAxisType type, float deg) {
        return type.axis.getDegreesQuaternion(deg);
    }

    public static class RotationAxisType {

        public static RotationAxisType POSITIVE_X = new RotationAxisType(Vec3f.POSITIVE_X);
        public static RotationAxisType POSITIVE_Y = new RotationAxisType(Vec3f.POSITIVE_Y);
        public static RotationAxisType POSITIVE_Z = new RotationAxisType(Vec3f.POSITIVE_Z);

        protected final Vec3f axis;
        protected RotationAxisType(Vec3f axis) {
            this.axis = axis;
        }
    }
}
