package ml.pkom.mcpitanlibarch.api.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.shedaniel.architectury.event.events.CommandRegistrationEvent;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import net.minecraft.server.command.ServerCommandSource;

import java.util.Map;

public class CommandRegistry {
    public static void register(String name, AbstractCommand command) {
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

    private static void forArgsCmd(AbstractCommand command, LiteralArgumentBuilder<ServerCommandSource> builder) {
        if (!command.getArgumentCommands().isEmpty()) {
            for (Map.Entry<String, AbstractCommand> argCmd : command.getArgumentCommands().entrySet()) {
                argCmd.getValue().init();
                LiteralArgumentBuilder<ServerCommandSource> builder2 = builder.then(LiteralArgumentBuilder.<ServerCommandSource>literal(argCmd.getKey()).executes(context -> {
                    ServerCommandEvent event = new ServerCommandEvent();
                    event.setContext(context);
                    argCmd.getValue().execute(event);
                    return argCmd.getValue().isSuccess;
                }));
                forArgsCmd(argCmd.getValue(), builder2);
            }
        }
    }
}
