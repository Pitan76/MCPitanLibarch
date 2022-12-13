package ml.pkom.mcpitanlibarch.api.command.argument;

import com.mojang.brigadier.arguments.StringArgumentType;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import ml.pkom.mcpitanlibarch.api.event.StringCommandEvent;

public abstract class StringCommand extends RequiredCommand<String> {
    @Override
    public StringArgumentType getArgumentType() {
        return StringArgumentType.string();
    }

    public abstract void execute(StringCommandEvent event);

    @Override
    public void execute(ServerCommandEvent event) {
        execute((StringCommandEvent) event);
    }
}
