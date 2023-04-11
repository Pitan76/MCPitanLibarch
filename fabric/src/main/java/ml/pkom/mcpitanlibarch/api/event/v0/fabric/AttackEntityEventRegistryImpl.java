package ml.pkom.mcpitanlibarch.api.event.v0.fabric;

import ml.pkom.mcpitanlibarch.api.event.v0.AttackEntityEventRegistry.AttackEntity;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;

public class AttackEntityEventRegistryImpl {
    public static void register(AttackEntity attackEntity) {
        AttackEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) -> attackEntity.attack(player, world, entity, hand, hitResult).asMinecraft()));
    }
}
