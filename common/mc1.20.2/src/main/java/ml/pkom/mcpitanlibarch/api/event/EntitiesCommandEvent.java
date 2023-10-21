package ml.pkom.mcpitanlibarch.api.event;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import ml.pkom.mcpitanlibarch.api.command.argument.EntitiesCommand;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;

public class EntitiesCommandEvent extends RequiredCommandEvent {
    public Entity getValue() {
        try {
            return EntityArgumentType.getEntity(context, ((EntitiesCommand) getCommand()).getArgumentName());
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
