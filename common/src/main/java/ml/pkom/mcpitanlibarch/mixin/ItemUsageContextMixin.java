package ml.pkom.mcpitanlibarch.mixin;

import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.hit.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemUsageContext.class)
public interface ItemUsageContextMixin {
    @Accessor
    public BlockHitResult getHit();
}