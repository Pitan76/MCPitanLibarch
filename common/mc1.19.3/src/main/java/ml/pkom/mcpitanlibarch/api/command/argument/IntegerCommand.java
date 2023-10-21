package ml.pkom.mcpitanlibarch.api.command.argument;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import ml.pkom.mcpitanlibarch.api.event.IntegerCommandEvent;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;

public abstract class IntegerCommand extends RequiredCommand<Integer> {
    @Override
    public IntegerArgumentType getArgumentType() {
        return IntegerArgumentType.integer();
    }

    public abstract void execute(IntegerCommandEvent event);

    @Override
    public void execute(ServerCommandEvent event) {
        execute((IntegerCommandEvent) event);
    }
}
