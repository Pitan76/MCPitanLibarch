package ml.pkom.mcpitanlibarch.api.command.argument;

import com.mojang.brigadier.arguments.StringArgumentType;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import ml.pkom.mcpitanlibarch.api.event.StringCommandEvent;

public abstract class GreedyStringCommand extends StringCommand {
    @Override
    public StringArgumentType getArgumentType() {
        return StringArgumentType.greedyString();
    }
}
