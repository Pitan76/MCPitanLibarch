package net.pitan76.mcpitanlib.test;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import ml.pkom.mcpitanlibarch.api.command.CommandSettings;
import ml.pkom.mcpitanlibarch.api.command.LiteralCommand;
import ml.pkom.mcpitanlibarch.api.command.argument.IntegerCommand;
import ml.pkom.mcpitanlibarch.api.event.IntegerCommandEvent;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import net.minecraft.item.ItemStack;

public class ExampleCommand extends LiteralCommand {

    @Override
    public void init(CommandSettings settings) {
        addArgumentCommand("item", new LiteralCommand() {
            @Override
            public void init(CommandSettings settings) {
                addArgumentCommand(new IntegerCommand() {
                    @Override
                    public void execute(IntegerCommandEvent event) {
                        try {
                            event.getPlayer().offerOrDrop(new ItemStack(ExampleMod.EXAMPLE_ITEM_SUPPLIER.getOrNull(), event.getValue()));
                        } catch (CommandSyntaxException ignored) {

                        }
                    }

                    @Override
                    public String getArgumentName() {
                        return "count";
                    }
                });
            }

            @Override
            public void execute(ServerCommandEvent event) {
                try {
                    event.getPlayer().offerOrDrop(new ItemStack(ExampleMod.EXAMPLE_ITEM_SUPPLIER.getOrNull()));
                } catch (CommandSyntaxException ignored) {

                }
            }
        });
    }

    @Override
    public void execute(ServerCommandEvent event) {
        System.out.println(event.getInput());
    }
}
