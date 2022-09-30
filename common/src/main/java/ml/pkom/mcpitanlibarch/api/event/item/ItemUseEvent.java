package ml.pkom.mcpitanlibarch.api.event.item;

import ml.pkom.mcpitanlibarch.api.entity.Player;
import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemUseEvent extends BaseEvent {

    public World world;
    public Player user;
    public Hand hand;

    public ItemUseEvent(World world, PlayerEntity user, Hand hand) {
        this.world = world;
        this.user = new Player(user);
        this.hand = hand;
    }
}
