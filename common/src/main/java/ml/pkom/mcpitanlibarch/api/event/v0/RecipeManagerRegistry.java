package ml.pkom.mcpitanlibarch.api.event.v0;

import ml.pkom.mcpitanlibarch.api.event.v0.event.RecipeManagerEvent;

import java.util.ArrayList;
import java.util.List;

public class RecipeManagerRegistry {
    public static List<CustomRecipeManager> managers = new ArrayList<>();

    public static void register(CustomRecipeManager manager) {
        managers.add(manager);
    }

    @FunctionalInterface
    public interface CustomRecipeManager {
        void apply(RecipeManagerEvent event);
    }
}
