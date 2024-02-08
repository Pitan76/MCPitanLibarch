package ml.pkom.mcpitanlibarch.api.event.item;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CraftEvent {

    public ItemStack stack;
    public World world;

    public CraftEvent(ItemStack stack, World world) {
        this.stack = stack;
        this.world = world;
    }

    public ItemStack getStack() {
        return stack;
    }

    public World getWorld() {
        return world;
    }

    public boolean isClient() {
        return world.isClient();
    }
}
