package ml.pkom.mcpitanlibarch.api.event.item;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemUseEvent extends BaseEvent {

    public World world;
    public Player user;
    public Hand hand;
    public ItemStack stack;

    public ItemUseEvent(World world, PlayerEntity user, Hand hand) {
        this.world = world;
        this.user = new Player(user);
        this.hand = hand;
        this.stack = user.getStackInHand(hand);
    }

    public ItemStack getStack() {
        return stack;
    }

    public Hand getHand() {
        return hand;
    }

    public World getWorld() {
        return world;
    }

    public Player getUser() {
        return user;
    }
}
