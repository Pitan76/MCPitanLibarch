package ml.pkom.mcpitanlibarch.api.event;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import ml.pkom.mcpitanlibarch.api.command.argument.PlayerCommand;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;

public class PlayerCommandEvent extends RequiredCommandEvent {
    public Entity getValue() {
        try {
            return EntityArgumentType.getPlayer(context, ((PlayerCommand) getCommand()).getArgumentName());
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
