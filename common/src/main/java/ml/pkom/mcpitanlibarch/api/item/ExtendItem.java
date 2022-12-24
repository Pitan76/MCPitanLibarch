package ml.pkom.mcpitanlibarch.api.item;

import ml.pkom.mcpitanlibarch.Dummy;
import ml.pkom.mcpitanlibarch.api.event.item.ItemUseEvent;
import ml.pkom.mcpitanlibarch.api.event.item.ItemUseOnBlockEvent;
import ml.pkom.mcpitanlibarch.mixin.ItemUsageContextMixin;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ExtendItem extends Item {
    public ExtendItem(Settings settings) {
        super(settings);
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
    public boolean hasRecipeRemainder() {
        return hasRecipeRemainder(new Dummy());
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

    public boolean hasRecipeRemainder(Dummy dummy) {
        return super.hasRecipeRemainder();
    }
}
