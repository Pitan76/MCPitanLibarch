package ml.pkom.mcpitanlibarch.api.util.client;

import ml.pkom.mcpitanlibarch.api.util.MathUtil;
import net.minecraft.client.util.math.MatrixStack;

import static ml.pkom.mcpitanlibarch.api.util.MathUtil.*;

public class MatrixStackUtil {
    public static void multiply(MatrixStack matrixStack, MathUtil.RotationAxisType type, float deg) {
        matrixStack.multiply(getRotationDegrees(type, deg));
    }
}
