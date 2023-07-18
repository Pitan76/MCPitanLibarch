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

    public static boolean damage(Entity target, DamageSource damageSource, float amount) {
        return target.damage(damageSource, amount);
    }

    public static boolean damageWithThrownProjectile(Entity target, float damageAmount, Entity projectile, Entity attacker) {
        return target.damage(DamageSourceUtil.thrownProjectile(projectile, attacker), damageAmount);
    }

    public static boolean damageWithMobProjectile(Entity target, float damageAmount, Entity projectile, LivingEntity attacker) {
        return target.damage(DamageSourceUtil.mobProjectile(projectile, attacker), damageAmount);
    }

    public static boolean damageWithMobAttack(Entity target, float damageAmount, Entity source, LivingEntity attacker) {
        return target.damage(DamageSourceUtil.mobAttack(attacker, source), damageAmount);
    }

    public static boolean damageWithPlayerAttack(Entity target, float damageAmount, Entity source, Player attacker) {
        return target.damage(DamageSourceUtil.playerAttack(attacker, source), damageAmount);
    }
}
