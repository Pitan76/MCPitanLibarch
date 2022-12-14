package ml.pkom.mcpitanlibarch.api.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.OptionalInt;
import java.util.UUID;

/*
PlayerEntity helper
 */
public class Player {
    private final PlayerEntity entity;

    public PlayerEntity getEntity() {
        return entity;
    }

    public PlayerEntity getPlayerEntity() {
        return getEntity();
    }

    public Player(PlayerEntity playerEntity) {
        this.entity = playerEntity;
    }

    /**
     * Get player inventory
     * @return PlayerInventory
     */
    public PlayerInventory getInv() {
        return getEntity().getInventory();
    }

    /**
     * Alias of getInv()
     * @return PlayerInventory
     */
    public PlayerInventory getInventory() {
        return getInv();
    }

    /**
     * Get armor's item stack list
     * @return DefaultedList<ItemStack>
     */
    public DefaultedList<ItemStack> getArmor() {
        return getInv().armor;
    }

    /**
     * Get main's item stack list
     * @return DefaultedList<ItemStack>
     */
    public DefaultedList<ItemStack> getMain() {
        return getInv().main;
    }

    /**
     * Get off hand's item stack list
     * @return DefaultedList<ItemStack>
     */
    public DefaultedList<ItemStack> getOffHand() {
        return getInv().offHand;
    }

    /**
     * Get select slot integer
     * @return int
     */
    public int getSelectSlot() {
        return getInv().selectedSlot;
    }

    /**
     * Get player inventory size
     * @return player inventory size
     */
    public int getInvSize() {
        return getInv().size();
    }

    public OptionalInt openGuiScreen(NamedScreenHandlerFactory factory) {
        return getEntity().openHandledScreen(factory);
    }

    public OptionalInt openGuiScreen(World world, BlockState state, BlockPos pos) {
        return openGuiScreen(state.createScreenHandlerFactory(world, pos));
    }

    public void insertStack(ItemStack stack) {
        getInv().insertStack(stack);
    }

    public void insertStack(int slot, ItemStack stack) {
        getInv().insertStack(slot, stack);
    }

    public void giveStack(ItemStack stack) {
        getEntity().giveItemStack(stack);
    }

    public String getName() {
        return getEntity().getName().getString();
    }

    public UUID getUUID() {
        return getEntity().getUuid();
    }

    public PlayerAbilities getAbilities() {
        return getEntity().getAbilities();
    }

    /**
     * Returns whether this player is in creative mode.
     */
    public boolean isCreative() {
        return getAbilities().creativeMode;
    }

    public World getWorld() {
        return getEntity().world;
    }

    public ScreenHandler getCurrentScreenHandler() {
        return getEntity().currentScreenHandler;
    }

    public boolean isSneaking() {
        return getEntity().isSneaking();
    }
}