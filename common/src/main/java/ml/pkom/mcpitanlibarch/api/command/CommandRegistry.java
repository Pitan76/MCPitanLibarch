package ml.pkom.mcpitanlibarch.api.command;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import ml.pkom.mcpitanlibarch.api.event.CommandEvent;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import net.minecraft.command.argument.ArgumentTypes;
import net.minecraft.server.command.ServerCommandSource;

import java.util.Map;

public class CommandRegistry {
    public static void register(String name, LiteralCommand command) {
        command.init();
        LiteralArgumentBuilder<ServerCommandSource> builder = LiteralArgumentBuilder.<ServerCommandSource>literal(name)
                .executes(context -> {
                    ServerCommandEvent event = new ServerCommandEvent();
                    event.setContext(context);
                    command.execute(event);
                    return command.isSuccess;
                });

        forArgsCmd(command, builder);

        CommandRegistrationEvent.EVENT.register((dispatcher, environment) ->
                dispatcher.register(builder)
        );
    }

    private static void forArgsCmd(AbstractCommand<?> absCmd, ArgumentBuilder<? extends ServerCommandSource, ?> builder) {

        if (!absCmd.getArgumentCommands().isEmpty()) {
            // 引数コマンド
            for (Map.Entry<String, ? extends AbstractCommand<?>> argCmd : absCmd.getArgumentCommands().entrySet()) {
                argCmd.getValue().init(new CommandSettings());

                if (argCmd.getValue() instanceof RequiredCommand) {
                    RequiredCommand command = (RequiredCommand) argCmd.getValue();
                    RequiredArgumentBuilder<ServerCommandSource, ?> builder2 = ((RequiredArgumentBuilder<ServerCommandSource, Object>) builder).then(RequiredArgumentBuilder.<ServerCommandSource, Object>argument(command.getArgumentName(), command.getArgumentType())
                            .executes(context -> {
                                        ServerCommandEvent event = new ServerCommandEvent();
                                        event.setContext(context);
                                        command.execute(event);
                                        return command.isSuccess;
                                    }
                            ));
                    forArgsCmd(command, builder2);
                    continue;
                }
                if (argCmd.getValue() instanceof LiteralCommand) {
                    LiteralCommand command = (LiteralCommand) argCmd.getValue();
                    LiteralArgumentBuilder<ServerCommandSource> builder2 = ((LiteralArgumentBuilder<ServerCommandSource>) builder).then(LiteralArgumentBuilder.<ServerCommandSource>literal(argCmd.getKey())
                            .executes(context -> {
                                        ServerCommandEvent event = new ServerCommandEvent();
                                        event.setContext(context);
                                        command.execute(event);
                                        return command.isSuccess;
                                    }
                            ));
                    forArgsCmd(command, builder2);
                }
            }
        }



    }
}
