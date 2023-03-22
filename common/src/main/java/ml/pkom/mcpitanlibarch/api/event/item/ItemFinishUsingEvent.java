package ml.pkom.mcpitanlibarch.api.event.item;

import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFinishUsingEvent extends BaseEvent {
    public ItemStack stack;
    public World world;
    public LivingEntity user;

    public ItemFinishUsingEvent(ItemStack stack, World world, LivingEntity user) {
        this.stack = stack;
        this.world = world;
        this.user = user;
    }

    public ItemStack getStack() {
        return stack;
    }

    public World getWorld() {
        return world;
    }

    public LivingEntity getUser() {
        return user;
    }
}
