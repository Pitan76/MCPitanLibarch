package ml.pkom.mcpitanlibarch.test;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import ml.pkom.mcpitanlibarch.api.command.AbstractCommand;
import ml.pkom.mcpitanlibarch.api.command.LiteralCommand;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import net.minecraft.item.ItemStack;

public class ExampleCommand extends LiteralCommand {

    @Override
    public void init() {
        addArgumentCommand("item", new LiteralCommand() {
            @Override
            public void init() {

            }

            @Override
            public void execute(ServerCommandEvent event) {
                try {
                    event.getPlayer().offerOrDrop(new ItemStack(ExampleMod.EXAMPLE_ITEM_SUPPLIER.getOrNull()));
                } catch (CommandSyntaxException e) {

                }
            }
        });
    }

    @Override
    public void execute(ServerCommandEvent event) {
        System.out.println(event.getInput());
    }
}
