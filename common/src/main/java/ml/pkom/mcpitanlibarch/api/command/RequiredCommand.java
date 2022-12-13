package ml.pkom.mcpitanlibarch.api.command;

import com.mojang.brigadier.arguments.ArgumentType;

public abstract class RequiredCommand extends AbstractCommand<Object> {
    public abstract String getArgumentName();

    public abstract ArgumentType<Object> getArgumentType();
}
