package ml.pkom.mcpitanlibarch.api.command.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import ml.pkom.mcpitanlibarch.api.command.AbstractCommand;

public abstract class RequiredCommand<T extends Object> extends AbstractCommand<T> {
    public abstract String getArgumentName();

    public abstract ArgumentType getArgumentType();
}
