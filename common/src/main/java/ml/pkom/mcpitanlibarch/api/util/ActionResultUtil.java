package ml.pkom.mcpitanlibarch.api.util;

import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;

public class ActionResultUtil {

    public static <T> TypedActionResult<T> typedActionResult(ActionResult result, T t, boolean swingHand) {
        switch (result) {
            case PASS:
                return TypedActionResult.pass(t);
            case SUCCESS:
                return TypedActionResult.success(t, swingHand);
            case FAIL:
                return TypedActionResult.fail(t);
            case CONSUME:
                return TypedActionResult.consume(t);
        }
        return TypedActionResult.pass(t);
    }

    public static <T> TypedActionResult<T> typedActionResult(ActionResult result, T t) {
        return typedActionResult(result, t, true);
    }

    public static <T> ActionResult actionResult(TypedActionResult<T> result) {
        return result.getResult();
    }
}
