package ml.pkom.mcpitanlibarch.api.command;

import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;

import java.util.*;

public abstract class AbstractCommand {

    private Map<String, AbstractCommand> argumentCommands = new HashMap<>();
    public int isSuccess = 1;

    abstract public void init();

    abstract public void execute(ServerCommandEvent event);

    public void success() {
        isSuccess = 1;
    }

    public void failure() {
        isSuccess = 0;
    }

    public Map<String, AbstractCommand> getArgumentCommands() {
        return argumentCommands;
    }

    public void setArgumentCommands(Map<String, AbstractCommand> argumentCommands) {
        this.argumentCommands = argumentCommands;
    }

    public void addArgumentCommand(String name, AbstractCommand command) {
        getArgumentCommands().put(name, command);
    }
}
