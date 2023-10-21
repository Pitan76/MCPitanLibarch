package ml.pkom.mcpitanlibarch.api.event;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import ml.pkom.mcpitanlibarch.api.command.argument.IntegerCommand;

public class IntegerCommandEvent extends RequiredCommandEvent {
    public Integer getValue() {
        return IntegerArgumentType.getInteger(context, ((IntegerCommand) getCommand()).getArgumentName());
    }
}
