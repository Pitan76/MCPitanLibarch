package ml.pkom.mcpitanlibarch.api.command;

import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;

import java.util.*;

public abstract class AbstractCommand<T> {

    private Map<String, AbstractCommand<T>> argumentCommands = new HashMap<>();
    public int isSuccess = 1;

    public void init() {

    }

    public void init(CommandSettings settings) {
        init();
    }

    abstract public void execute(T event);

    public void success() {
        isSuccess = 1;
    }

    public void failure() {
        isSuccess = 0;
    }

    public Map<String, AbstractCommand<T>> getArgumentCommands() {
        return argumentCommands;
    }

    public void setArgumentCommands(Map<String, AbstractCommand<T>> argumentCommands) {
        this.argumentCommands = argumentCommands;
    }

    public void addArgumentCommand(String name, AbstractCommand<T> command) {
        getArgumentCommands().put(name, command);
    }
}
