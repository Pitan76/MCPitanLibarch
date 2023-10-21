package ml.pkom.mcpitanlibarch.api.event;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import ml.pkom.mcpitanlibarch.api.command.argument.EntityCommand;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;

public class EntityCommandEvent extends RequiredCommandEvent {
    public Entity getValue() {
        try {
            return EntityArgumentType.getEntity(context, ((EntityCommand) getCommand()).getArgumentName());
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
