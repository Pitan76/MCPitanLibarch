package ml.pkom.mcpitanlibarch.api.event;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.StringRange;

public class CommandEvent<T> {
    public CommandContext<T> context;

    public CommandContext<T> getContext() {
        return context;
    }

    public void setContext(CommandContext<T> context) {
        this.context = context;
    }

    public String getInput() {
        return context.getInput();
    }

    public StringRange getRange() {
        return context.getRange();
    }
}
