package ml.pkom.mcpitanlibarch.api.event.v0.fabric;

import me.shedaniel.architectury.event.EventResult;
import ml.pkom.mcpitanlibarch.api.event.v0.AttackEntityEventRegistry.AttackEntity;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.util.ActionResult;

public class AttackEntityEventRegistryImpl {
    public static void register(AttackEntity attackEntity) {
        AttackEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) -> toMC(attackEntity.attack(player, world, entity, hand, hitResult))));
    }

    private static ActionResult toMC(EventResult result) {
        if (result.equals(EventResult.interruptTrue())) return ActionResult.SUCCESS;
        if (result.equals(EventResult.interruptFalse())) return ActionResult.FAIL;
        if (result.equals(EventResult.interruptDefault())) return ActionResult.CONSUME;
        if (result.equals(EventResult.pass())) return ActionResult.PASS;
        return ActionResult.PASS;
    }
}
