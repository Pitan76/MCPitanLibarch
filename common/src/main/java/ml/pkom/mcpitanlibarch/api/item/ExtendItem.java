package ml.pkom.mcpitanlibarch.api.item;

import ml.pkom.mcpitanlibarch.Dummy;
import ml.pkom.mcpitanlibarch.api.event.item.*;
import ml.pkom.mcpitanlibarch.mixin.ItemUsageContextMixin;
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
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExtendItem extends Item {
    public ExtendItem(Settings settings) {
        super(settings);
    }

    public ExtendItem(CompatibleItemSettings settings) {
        super(settings.build());
    }

    @Deprecated
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return onRightClick(new ItemUseEvent(world, user, hand));
    }

    @Deprecated
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemUsageContextMixin contextAccessor = (ItemUsageContextMixin) context;
        return onRightClickOnBlock(new ItemUseOnBlockEvent(context.getPlayer(), context.getHand(), contextAccessor.getHit()));
    }

    @Deprecated
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        return onFinishUsing(new ItemFinishUsingEvent(stack, world, user));
    }

    @Deprecated
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        return onRightClickOnEntity(new ItemUseOnEntityEvent(stack, user, entity, hand));
    }

    @Deprecated
    @Override
    public boolean hasRecipeRemainder() {
        return hasRecipeRemainder(new Dummy());
    }

    @Deprecated
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        appendTooltip(new ItemAppendTooltipEvent(stack, world, tooltip, context));
    }

    /**
     * item right click event
     *
     * @param event ItemUseEvent
     * @return ActionResultType
     */
    public TypedActionResult<ItemStack> onRightClick(ItemUseEvent event) {
        return super.use(event.world, event.user.getPlayerEntity(), event.hand);
    }

    /**
     * item right click event on block
     * @param event ItemUseOnBlockEvent
     * @return ActionResultType
     */
    public ActionResult onRightClickOnBlock(ItemUseOnBlockEvent event) {
        return super.useOnBlock(event.toIUC());
    }

    public ItemStack onFinishUsing(ItemFinishUsingEvent event) {
        return super.finishUsing(event.stack, event.world, event.user);
    }

    public ActionResult onRightClickOnEntity(ItemUseOnEntityEvent event) {
        return super.useOnEntity(event.stack, event.user.getEntity(), event.entity, event.hand);
    }

    public boolean hasRecipeRemainder(Dummy dummy) {
        return super.hasRecipeRemainder();
    }

    public void appendTooltip(ItemAppendTooltipEvent event) {
        super.appendTooltip(event.stack, event.world, event.tooltip, event.context);
    }

    @Deprecated
    @Override
    public void onCraft(ItemStack stack, World world) {
        onCraft(new CraftEvent(stack, world));
    }

    public void onCraft(CraftEvent event) {
        super.onCraft(event.stack, event.world);
    }
}
