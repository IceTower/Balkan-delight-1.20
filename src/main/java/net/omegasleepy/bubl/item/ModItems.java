package net.omegasleepy.bubl.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.omegasleepy.bubl.TutorialMod;
import net.omegasleepy.bubl.item.custom.ChiselItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> BUBBLIUM = ITEMS.register("bubblium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BUBBLIUM = ITEMS.register("raw_bubblium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHISEL = ITEMS.register("bubblium_chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
