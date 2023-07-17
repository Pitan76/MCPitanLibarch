package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class DamageSourceUtil {
    public static DamageSource thrownProjectile(Entity projectile, Entity attacker, Entity source) {
        return source.getDamageSources().thrown(projectile, attacker);
    }

    public static DamageSource thrownProjectile(Entity projectile, Entity attacker) {
        return thrownProjectile(projectile, attacker, projectile);
    }

    public static DamageSource playerAttack(Player attacker, Entity source) {
        return source.getDamageSources().playerAttack(attacker.getPlayerEntity());
    }

    public static DamageSource playerAttack(Player attacker) {
        return playerAttack(attacker, attacker.getPlayerEntity());
    }

    public static DamageSource mobAttack(LivingEntity attacker, Entity source) {
        return source.getDamageSources().mobAttack(attacker);
    }

    public static DamageSource mobAttack(LivingEntity attacker) {
        return mobAttack(attacker, attacker);
    }

    public static DamageSource mobProjectile(Entity projectile, LivingEntity attacker, Entity source) {
        return source.getDamageSources().mobProjectile(projectile, attacker);
    }

    public static DamageSource mobProjectile(Entity projectile, LivingEntity attacker) {
        return mobProjectile(projectile, attacker, projectile);
    }
}
