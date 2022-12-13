package ml.pkom.mcpitanlibarch.api.event;

public abstract class RequiredCommandEvent extends ServerCommandEvent {
    public abstract Object getValue();
}
