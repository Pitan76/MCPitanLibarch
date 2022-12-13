package ml.pkom.mcpitanlibarch.api.command.argument;

import ml.pkom.mcpitanlibarch.api.event.ItemCommandEvent;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import net.minecraft.command.argument.ItemStackArgumentType;
import net.minecraft.entity.Entity;

public abstract class ItemCommand extends RequiredCommand<Entity> {
    @Override
    public ItemStackArgumentType getArgumentType() {
        return ItemStackArgumentType.itemStack();
    }

    public abstract void execute(ItemCommandEvent event);

    @Override
    public void execute(ServerCommandEvent event) {
        execute((ItemCommandEvent) event);
    }
}
