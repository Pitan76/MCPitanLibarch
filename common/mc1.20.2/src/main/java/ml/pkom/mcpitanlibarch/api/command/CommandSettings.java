package ml.pkom.mcpitanlibarch.api.command;

import net.minecraft.server.command.ServerCommandSource;

public class CommandSettings {
    private int permissionLevel = -1;
    private ICustom iCustom = null;

    public boolean requires(ServerCommandSource source) {

        return customRequires(source) && (permissionLevel == -1 || source.hasPermissionLevel(permissionLevel));
    }

    private boolean customRequires(ServerCommandSource source) {
        if (iCustom == null) return true;
        return iCustom.custom(source);
    }

    public CommandSettings permissionLevel(int level) {
        this.permissionLevel = level;
        return this;
    }

    public CommandSettings custom(ICustom iCustom) {
        this.iCustom = iCustom;
        return this;
    }

    @FunctionalInterface
    public interface ICustom {
        boolean custom(ServerCommandSource source);
    }
}
