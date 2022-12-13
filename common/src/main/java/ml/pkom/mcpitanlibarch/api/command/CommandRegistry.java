package ml.pkom.mcpitanlibarch.api.command;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import ml.pkom.mcpitanlibarch.api.command.argument.*;
import ml.pkom.mcpitanlibarch.api.event.*;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

import java.util.Map;

public class CommandRegistry {

    @Deprecated
    public static CommandRegistryAccess latestCommandRegistryAccess;

    public static void register(String name, LiteralCommand command) {
        CommandRegistrationEvent.EVENT.register((dispatcher, registry, environment) -> {
            latestCommandRegistryAccess = registry;

            CommandSettings settings = new CommandSettings();
            command.init(settings);

            LiteralArgumentBuilder<ServerCommandSource> builder = LiteralArgumentBuilder.<ServerCommandSource>literal(name).requires(settings::requires)
                    .executes(context -> {
                        ServerCommandEvent event = new ServerCommandEvent();
                        event.setContext(context);
                        command.execute(event);
                        return command.isSuccess;
                    });

            forArgsCmd(command, builder);

            //register(builder);
            dispatcher.register(builder);
        });
    }

    public static void register(LiteralArgumentBuilder<ServerCommandSource> builder) {
        CommandRegistrationEvent.EVENT.register((dispatcher, registry, environment) -> {
                    latestCommandRegistryAccess = registry;
                    dispatcher.register(builder);
                }
        );
    }

    private static <T extends ArgumentBuilder<ServerCommandSource, T>> void forArgsCmd(AbstractCommand<?> absCmd, ArgumentBuilder<ServerCommandSource, T> builder) {

        if (!absCmd.getArgumentCommands().isEmpty()) {
            // 引数コマンド
            for (Map.Entry<String, ? extends AbstractCommand<?>> argCmd : absCmd.getArgumentCommands().entrySet()) {
                ArgumentBuilder<ServerCommandSource, ?> nextBuilder = null;
                argCmd.getValue().init(new CommandSettings());

                if (argCmd.getValue() instanceof LiteralCommand) {
                    LiteralCommand command = (LiteralCommand) argCmd.getValue();
                    nextBuilder = CommandManager.literal(argCmd.getKey())
                            .executes(context -> {
                                        ServerCommandEvent event = new ServerCommandEvent();
                                        event.setContext(context);
                                        event.setCommand(command);
                                        command.execute(event);
                                        return command.isSuccess;
                                    }
                            );
                }

                if (argCmd.getValue() instanceof RequiredCommand) {
                    RequiredCommand<?> command = (RequiredCommand<?>) argCmd.getValue();

                    nextBuilder = CommandManager.argument(argCmd.getKey(), command.getArgumentType())
                            .executes(context -> {
                                        ServerCommandEvent event = new ServerCommandEvent();
                                        if (command instanceof IntegerCommand) {
                                            event = new IntegerCommandEvent();
                                        }
                                        if (command instanceof StringCommand) {
                                            event = new StringCommandEvent();
                                        }
                                        if (command instanceof EntityCommand) {
                                            event = new EntityCommandEvent();
                                        }
                                        if (command instanceof EntitiesCommand) {
                                            event = new EntitiesCommandEvent();
                                        }
                                        if (command instanceof PlayerCommand) {
                                            event = new PlayerCommandEvent();
                                        }
                                        if (command instanceof PlayersCommand) {
                                            event = new PlayersCommandEvent();
                                        }
                                        if (command instanceof ItemCommand) {
                                            event = new ItemCommandEvent();
                                        }

                                        event.setContext(context);
                                        event.setCommand(command);
                                        command.execute(event);
                                        return command.isSuccess;
                                    }
                            );
                }
                forArgsCmd(argCmd.getValue(), nextBuilder);
                builder.then(nextBuilder);
            }
        }
    }
}