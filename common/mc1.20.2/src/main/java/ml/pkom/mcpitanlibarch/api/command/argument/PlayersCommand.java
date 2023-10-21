package ml.pkom.mcpitanlibarch.api.command.argument;

import ml.pkom.mcpitanlibarch.api.event.EntityCommandEvent;
import ml.pkom.mcpitanlibarch.api.event.PlayersCommandEvent;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;

public abstract class PlayersCommand extends RequiredCommand<Entity> {
    @Override
    public EntityArgumentType getArgumentType() {
        return EntityArgumentType.players();
    }

    public abstract void execute(PlayersCommandEvent event);

    @Override
    public void execute(ServerCommandEvent event) {
        execute((PlayersCommandEvent) event);
    }
}
