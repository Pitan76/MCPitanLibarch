package ml.pkom.mcpitanlibarch.api.util;

import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import net.fabricmc.api.EnvType;

import java.nio.file.Path;
import java.util.Collection;

public class PlatformUtil {
    public static boolean isDevelopmentEnvironment() {
        return Platform.isDevelopmentEnvironment();
    }

    public static boolean isFabric() {
        return Platform.isFabric();
    }

    public static boolean isForge() {
        return Platform.isForge();
    }

    public static boolean isModLoaded(String id) {
        return Platform.isModLoaded(id);
    }

    public static boolean isClient() {
        return Platform.getEnvironment() == Env.CLIENT;
    }

    public static boolean isServer() {
        return Platform.getEnvironment() == Env.SERVER;
    }

    public static Path getConfigFolder() {
        return Platform.getConfigFolder();
    }

    public static Path getGameFolder() {
        return Platform.getGameFolder();
    }

    public static Path getModsFolder() {
        return Platform.getModsFolder();
    }

    public static Collection<String> getModIds() {
        return Platform.getModIds();
    }

    public static EnvType getEnv() {
        return Platform.getEnv();
    }

    public static String getGameVersion() {
        return Platform.getMinecraftVersion();
    }
}
