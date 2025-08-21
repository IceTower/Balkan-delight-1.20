package net.omegasleepy.balkan.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.omegasleepy.balkan.TutorialMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> BUBBLIUM = ITEMS.register("bubblium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BUBBLIUM = ITEMS.register("raw_bubblium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LOVIUM = ITEMS.register("lovium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PIRIUM = ITEMS.register("pirium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SUNIUM = ITEMS.register("sunium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TRENIUM = ITEMS.register("trenium",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
