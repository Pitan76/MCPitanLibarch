package ml.pkom.mcpitanlibarch.api.util;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.World;

public class EntityUtil {
    public static World getWorld(Entity entity) {
        return entity.getWorld();
    }

    public static boolean damage(Entity entity, DamageSource damageSource, float amount) {
        return entity.damage(damageSource, amount);
    }

    public static boolean damageWithThrownProjectile(float damageAmount, Entity projectile, Entity attacker) {
        return projectile.damage(DamageSourceUtil.thrownProjectile(projectile, attacker), damageAmount);
    }

    public static boolean damageWithMobProjectile(float damageAmount, Entity projectile, LivingEntity attacker) {
        return projectile.damage(DamageSourceUtil.mobProjectile(projectile, attacker), damageAmount);
    }

    public static boolean damageWithMobAttack(float damageAmount, Entity source, LivingEntity attacker) {
        return source.damage(DamageSourceUtil.mobAttack(attacker, source), damageAmount);
    }

    public static boolean damageWithPlayerAttack(float damageAmount, Entity source, Player attacker) {
        return source.damage(DamageSourceUtil.playerAttack(attacker, source), damageAmount);
    }
}
