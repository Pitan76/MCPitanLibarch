package ml.pkom.mcpitanlibarch.api.command.argument;

import ml.pkom.mcpitanlibarch.api.event.PlayerCommandEvent;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;

public abstract class PlayerCommand extends RequiredCommand<Entity> {
    @Override
    public EntityArgumentType getArgumentType() {
        return EntityArgumentType.player();
    }

    public abstract void execute(PlayerCommandEvent event);

    @Override
    public void execute(ServerCommandEvent event) {
        execute((PlayerCommandEvent) event);
    }
}
