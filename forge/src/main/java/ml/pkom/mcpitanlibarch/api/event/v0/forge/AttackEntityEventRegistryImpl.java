package ml.pkom.mcpitanlibarch.api.event.v0.forge;

import dev.architectury.event.EventResult;
import ml.pkom.mcpitanlibarch.api.event.v0.AttackEntityEventRegistry.AttackEntity;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class AttackEntityEventRegistryImpl {
    private static final List<AttackEntity> attackEntities = new ArrayList<>();

    public static void register(AttackEntity attackEntity) {
        attackEntities.add(attackEntity);
    }

    @SubscribeEvent
    public static void event(AttackEntityEvent event) {
        for (AttackEntity attackEntity : attackEntities) {
            EventResult result = attackEntity.attack(event.getPlayer(), event.getPlayer().world, event.getTarget(), event.getPlayer().getActiveHand(), null);
            if (result.isFalse()) {
                event.setCanceled(true);
            }
        }
    }
}
