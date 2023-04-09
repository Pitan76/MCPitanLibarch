package ml.pkom.mcpitanlibarch.mixin;

import ml.pkom.mcpitanlibarch.api.event.item.*;
import ml.pkom.mcpitanlibarch.api.item.ExtendItemProvider;
import ml.pkom.mcpitanlibarch.api.item.ExtendItemProvider.Options;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (this instanceof ExtendItemProvider) {
            ExtendItemProvider provider = (ExtendItemProvider) this;
            Options options = new Options();
            TypedActionResult<ItemStack> returnValue = provider.onRightClick(new ItemUseEvent(world, user, hand), options);
            if (options.cancel)
                cir.setReturnValue(returnValue);
        }
    }

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (this instanceof ExtendItemProvider) {
            ExtendItemProvider provider = (ExtendItemProvider) this;
            ItemUsageContextMixin contextAccessor = (ItemUsageContextMixin) context;
            Options options = new Options();
            ActionResult returnValue = provider.onRightClickOnBlock(new ItemUseOnBlockEvent(context.getPlayer(), context.getHand(), contextAccessor.getHit()), options);
            if (options.cancel)
                cir.setReturnValue(returnValue);
        }
    }

    @Inject(method = "useOnEntity", at = @At("HEAD"), cancellable = true)
    private void useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (this instanceof ExtendItemProvider) {
            ExtendItemProvider provider = (ExtendItemProvider) this;
            Options options = new Options();
            ActionResult returnValue = provider.onRightClickOnEntity(new ItemUseOnEntityEvent(stack, user, entity, hand), options);

            if (options.cancel)
                cir.setReturnValue(returnValue);
        }
    }

    @Inject(method = "finishUsing", at = @At("HEAD"), cancellable = true)
    private void finishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (this instanceof ExtendItemProvider) {
            ExtendItemProvider provider = (ExtendItemProvider) this;
            Options options = new Options();
            ItemStack returnValue = provider.onFinishUsing(new ItemFinishUsingEvent(stack, world, user), options);
            if (options.cancel)
                cir.setReturnValue(returnValue);
        }
    }

    @Inject(method = "hasRecipeRemainder", at = @At("HEAD"), cancellable = true)
    private void hasRecipeRemainder(CallbackInfoReturnable<Boolean> cir) {
        if (this instanceof ExtendItemProvider) {
            ExtendItemProvider provider = (ExtendItemProvider) this;
            Options options = new Options();
            boolean returnValue = provider.hasRecipeRemainder(options);
            if (options.cancel)
                cir.setReturnValue(returnValue);
        }
    }

    @Inject(method = "appendTooltip", at = @At("HEAD"), cancellable = true)
    private void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        if (this instanceof ExtendItemProvider) {
            ExtendItemProvider provider = (ExtendItemProvider) this;
            Options options = new Options();
            provider.appendTooltip(new ItemAppendTooltipEvent(stack, world, tooltip, context), options);
            if (options.cancel)
                ci.cancel();
        }
    }

}
