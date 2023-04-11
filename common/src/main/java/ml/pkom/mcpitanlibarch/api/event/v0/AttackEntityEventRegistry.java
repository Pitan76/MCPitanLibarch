package ml.pkom.mcpitanlibarch.api.event.v0;

import dev.architectury.injectables.annotations.ExpectPlatform;
import me.shedaniel.architectury.event.EventResult;
import ml.pkom.mcpitanlibarch.api.entity.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityEventRegistry {
    @ExpectPlatform
    public static void register(AttackEntity attackEntity) {

    }

    public interface AttackEntity {
        default EventResult attack(PlayerEntity player, World level, Entity target, Hand hand, @Nullable EntityHitResult result) {
            return attack(new Player(player), level, target, hand, result);
        }

        EventResult attack(Player player, World level, Entity target, Hand hand, @Nullable EntityHitResult result);
    }
}
