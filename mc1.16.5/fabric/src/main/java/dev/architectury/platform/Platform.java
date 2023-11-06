package dev.architectury.platform;

import me.shedaniel.architectury.utils.Env;
import net.fabricmc.api.EnvType;

public class Platform {
    public static EnvType getEnv() {
        return me.shedaniel.architectury.platform.Platform.getEnv();
    }

    public static Env getEnvironment() {
        return me.shedaniel.architectury.platform.Platform.getEnvironment();
    }

    public static boolean isDevelopmentEnvironment() {
        return me.shedaniel.architectury.platform.Platform.isDevelopmentEnvironment();
    }

    public static boolean isForge() {
        return me.shedaniel.architectury.platform.Platform.isForge();
    }

    public static boolean isFabric() {
        return me.shedaniel.architectury.platform.Platform.isFabric();
    }

    public static boolean isModLoaded(String id) {
        return me.shedaniel.architectury.platform.Platform.isModLoaded(id);
    }

}
