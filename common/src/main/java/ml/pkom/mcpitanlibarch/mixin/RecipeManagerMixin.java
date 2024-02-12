package ml.pkom.mcpitanlibarch.mixin;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import ml.pkom.mcpitanlibarch.api.event.v0.RecipeManagerRegistry;
import ml.pkom.mcpitanlibarch.api.event.v0.event.RecipeManagerEvent;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {
    @Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V",
            at = @At(value = "INVOKE", target = "Ljava/util/Map;entrySet()Ljava/util/Set;", ordinal = 1),
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void invokeApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci, Map<RecipeType<?>, ImmutableMap.Builder<Identifier, Recipe<?>>> map2) {
        RecipeManagerRegistry.managers.forEach((manager) -> manager.apply(new RecipeManagerEvent(map, resourceManager, profiler, map2)));
    }

}
