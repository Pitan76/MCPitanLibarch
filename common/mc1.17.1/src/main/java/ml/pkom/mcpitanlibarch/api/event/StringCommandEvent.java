package ml.pkom.mcpitanlibarch.api.event;

import com.mojang.brigadier.arguments.StringArgumentType;
import ml.pkom.mcpitanlibarch.api.command.argument.StringCommand;

public class StringCommandEvent extends RequiredCommandEvent {
    public String getValue() {
        return StringArgumentType.getString(context, ((StringCommand) getCommand()).getArgumentName());
    }
}
