package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class DamageSourceUtil {
    public static DamageSource thrownProjectile(Entity projectile, Entity attacker, Entity source) {
        return thrownProjectile(projectile, attacker);
    }

    public static DamageSource thrownProjectile(Entity projectile, Entity attacker) {
        return DamageSource.thrownProjectile(projectile, attacker);
    }

    public static DamageSource playerAttack(Player attacker, Entity source) {
        return playerAttack(attacker);
    }

    public static DamageSource playerAttack(Player attacker) {
        return DamageSource.player(attacker.getPlayerEntity());
    }

    public static DamageSource mobAttack(LivingEntity attacker, Entity source) {
        return mobAttack(attacker);
    }

    public static DamageSource mobAttack(LivingEntity attacker) {
        return DamageSource.mob(attacker);
    }

    public static DamageSource mobProjectile(Entity projectile, LivingEntity attacker, Entity source) {
        return mobProjectile(projectile, attacker);
    }

    public static DamageSource mobProjectile(Entity projectile, LivingEntity attacker) {
        return DamageSource.mobProjectile(projectile, attacker);
    }
}
