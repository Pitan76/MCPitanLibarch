package ml.pkom.mcpitanlibarch.api.event.item;

import ml.pkom.mcpitanlibarch.api.event.BaseEvent;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemAppendTooltipEvent extends BaseEvent {
    public ItemStack stack;
    public World world;
    public List<Text> tooltip;
    public TooltipContext context;

    public ItemAppendTooltipEvent(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        this.stack = stack;
        this.world = world;
        this.tooltip = tooltip;
        this.context = context;
    }

    public ItemStack getStack() {
        return stack;
    }

    public World getWorld() {
        return world;
    }

    public List<Text> getTooltip() {
        return tooltip;
    }

    public TooltipContext getContext() {
        return context;
    }
}
