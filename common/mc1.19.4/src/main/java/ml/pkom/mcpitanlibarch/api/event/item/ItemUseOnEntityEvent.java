package ml.pkom.mcpitanlibarch.api.event.item;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class ItemUseOnEntityEvent extends BaseEvent {

    public ItemStack stack;
    public Player user;
    public LivingEntity entity;
    public Hand hand;

    public ItemUseOnEntityEvent(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        this.stack = stack;
        this.user = new Player(user);
        this.hand = hand;
        this.entity = entity;
    }

    public ItemStack getStack() {
        return stack;
    }

    public Hand getHand() {
        return hand;
    }

    public Player getUser() {
        return user;
    }

    public LivingEntity getEntity() {
        return entity;
    }
}
