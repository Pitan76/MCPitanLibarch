package ml.pkom.mcpitanlibarch.api.event;

import ml.pkom.mcpitanlibarch.api.command.argument.ItemCommand;
import net.minecraft.command.argument.ItemStackArgumentType;
import net.minecraft.item.Item;

public class ItemCommandEvent extends RequiredCommandEvent {
    public Item getValue() {
        return ItemStackArgumentType.getItemStackArgument(context, ((ItemCommand) getCommand()).getArgumentName()).getItem();
    }
}
