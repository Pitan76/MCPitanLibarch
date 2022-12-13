package ml.pkom.mcpitanlibarch.api.command;

import ml.pkom.mcpitanlibarch.api.command.argument.RequiredCommand;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCommand<T> {

    private Map<String, AbstractCommand<?>> argumentCommands = new HashMap<>();
    public int isSuccess = 1;

    public void init() {

    }

    public void init(CommandSettings settings) {
        init();
    }

    public void success() {
        isSuccess = 1;
    }

    public void failure() {
        isSuccess = 0;
    }

    public Map<String, AbstractCommand<?>> getArgumentCommands() {
        return argumentCommands;
    }

    public void setArgumentCommands(Map<String, AbstractCommand<?>> argumentCommands) {
        this.argumentCommands = argumentCommands;
    }

    public void addArgumentCommand(String name, AbstractCommand<?> command) {
        getArgumentCommands().put(name, command);
    }

    public void addArgumentCommand(RequiredCommand<?> command) {
        getArgumentCommands().put(command.getArgumentName(), command);
    }

    public abstract void execute(ServerCommandEvent event);
}
