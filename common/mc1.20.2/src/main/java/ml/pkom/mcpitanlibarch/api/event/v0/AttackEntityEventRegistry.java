package ml.pkom.mcpitanlibarch.api.event.v0;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.PlayerEvent;
import ml.pkom.mcpitanlibarch.api.entity.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityEventRegistry {
    public static void register(AttackEntity attackEntity) {
        PlayerEvent.ATTACK_ENTITY.register(attackEntity::attack);
    }

    public interface AttackEntity {
        default EventResult attack(PlayerEntity player, World level, Entity target, Hand hand, @Nullable EntityHitResult result) {
            return attack(new Player(player), level, target, hand, result);
        }

        EventResult attack(Player player, World level, Entity target, Hand hand, @Nullable EntityHitResult result);
    }
}
