package ml.pkom.mcpitanlibarch.api.item;

import ml.pkom.mcpitanlibarch.api.util.ItemUtil;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

import java.util.ArrayList;
import java.util.List;

public class CreativeTabManager {
    private static final List<BookingItem> bookingItems = new ArrayList<>();

    // グループ予約済みアイテム
    public static class BookingItem {
        public ItemGroup itemGroup;
        public Identifier identifier;
        private BookingItem(ItemGroup itemGroup, Identifier identifier) {
            this.itemGroup = itemGroup;
            this.identifier = identifier;
        }
    }

    public static void allRegister() {
        if (bookingItems.isEmpty()) return;
        for (BookingItem bookingItem : bookingItems) {
            bookingItem.itemGroup.appendStacks(DefaultedList.copyOf(ItemStack.EMPTY, new ItemStack(ItemUtil.fromId(bookingItem.identifier))));
            //CreativeTabRegistry.append(bookingItem.itemGroup, ItemUtil.fromId(bookingItem.identifier));
            bookingItems.remove(bookingItem);
        }
    }

    public static void register(Identifier identifier) {
        if (bookingItems.isEmpty()) return;
        for (BookingItem bookingItem : bookingItems) {
            if (!bookingItem.identifier.toString().equals(identifier.toString())) continue;
            bookingItem.itemGroup.appendStacks(DefaultedList.copyOf(ItemStack.EMPTY, new ItemStack(ItemUtil.fromId(bookingItem.identifier))));
            //CreativeTabRegistry.append(bookingItem.itemGroup, ItemUtil.fromId(bookingItem.identifier));
            bookingItems.remove(bookingItem);
            break;
        }
    }

    public static void addItem(ItemGroup itemGroup, Identifier identifier) {
        bookingItems.add(new BookingItem(itemGroup, identifier));
    }
}
