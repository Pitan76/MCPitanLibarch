package ml.pkom.mcpitanlibarch.api.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import ml.pkom.easyapi.config.Config;
import ml.pkom.mcpitanlibarch.api.command.argument.StringCommand;
import ml.pkom.mcpitanlibarch.api.event.ServerCommandEvent;
import ml.pkom.mcpitanlibarch.api.event.StringCommandEvent;
import ml.pkom.mcpitanlibarch.api.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.function.Supplier;

public class ConfigCommand extends LiteralCommand {

    public final Config config;
    public File file;
    public Supplier<Boolean> defaultConfigFunction;
    public String prefix = "[MCPitanLib]";
    
    public ConfigCommand(Config config, File file, String prefix) {
        this.config = config;
        this.file = file;
        this.prefix = prefix;
    }
    
    public ConfigCommand(Config config, File file, String prefix, @Nullable Supplier<Boolean> supplier) {
        this.config = config;
        this.file = file;
        this.defaultConfigFunction = supplier;
        this.prefix = prefix;
    }
    
    public ConfigCommand(Config config, File file, @Nullable Supplier<Boolean> supplier) {
        this.config = config;
        this.file = file;
        this.defaultConfigFunction = supplier;
    }

    public ConfigCommand(Config config, File file) {
        this.config = config;
        this.file = file;
    }

    public ConfigCommand(Config config) {
        this.config = config;
    }

    @Override
    public void init(CommandSettings settings) {
        settings.permissionLevel(3);

        addArgumentCommand("set", new StringCommand() {
            @Override
            public String getArgumentName() {
                return "key";
            }

            @Override
            public void init(CommandSettings settings) {

                addArgumentCommand("value", new StringCommand() {
                    @Override
                    public String getArgumentName() {
                        return "value";
                    }

                    @Override
                    public void execute(StringCommandEvent event) {
                        String key = StringArgumentType.getString(event.context, "key");
                        String value = StringArgumentType.getString(event.context, "value");
                        if (config.get(key) == null) {
                            event.sendFailure(TextUtil.literal(prefix + " Key not found."));
                            return;
                        }
                        if (config.get(key).getClass() == String.class) {
                            config.setString(key, value);
                            event.sendSuccess(TextUtil.literal(prefix + " Set " + key + " to " + value), false);

                        } else if (config.get(key).getClass() == Integer.class) {
                            config.setInt(key, Integer.parseInt(value));
                            event.sendSuccess(TextUtil.literal(prefix + " Set " + key + " to " + value), false);

                        } else if (config.get(key).getClass() == Double.class) {
                            config.setDouble(key, Double.parseDouble(value));
                            event.sendSuccess(TextUtil.literal(prefix + " Set " + key + " to " + value), false);

                        } else if (config.get(key).getClass() == Boolean.class) {
                            config.setBoolean(key, Boolean.parseBoolean(value));
                            event.sendSuccess(TextUtil.literal(prefix + " Set " + key + " to " + value), false);

                        } else {
                            event.sendFailure(TextUtil.literal(prefix + " Not supported type."));
                        }
                        if (file != null)
                            config.save(file);
                    }
                });
            }

            @Override
            public void execute(StringCommandEvent event) {
            }
        });

        addArgumentCommand("get", new StringCommand() {
            @Override
            public String getArgumentName() {
                return "key";
            }

            @Override
            public void execute(StringCommandEvent event) {
                String key = StringArgumentType.getString(event.context, "key");
                if (config.get(key) == null) {
                    event.sendFailure(TextUtil.literal(prefix + " Key not found."));
                    return;
                }
                event.sendSuccess(TextUtil.literal(prefix + " " + key + ": " + config.get(key).toString()), false);
            }
        });

        addArgumentCommand("list", new LiteralCommand() {
            @Override
            public void execute(ServerCommandEvent event) {
                event.sendSuccess(TextUtil.literal(prefix + " Config List"), false);
                for (String key : config.configMap.keySet()) {
                    event.sendSuccess(TextUtil.literal(" - " + key + ": " + config.get(key).toString()), false);
                }
            }
        });

        if (defaultConfigFunction != null) {
        addArgumentCommand("reset", new LiteralCommand() {
            @Override
            public void execute(ServerCommandEvent event) {
                config.configMap.clear();
                defaultConfigFunction.get();
                if (file != null)
                    config.save(file);
                event.sendSuccess(TextUtil.literal(prefix + " Reset config."), false);
            }
        });
        }
    }

    @Override
    public void execute(ServerCommandEvent event) {

    }
}
