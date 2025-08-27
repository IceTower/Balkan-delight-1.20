package net.omegasleepy.bubl.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.omegasleepy.bubl.TutorialMod;
import net.omegasleepy.bubl.item.custom.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> BUBBLIUM = ITEMS.register("bubblium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BUBBLIUM = ITEMS.register("raw_bubblium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHISEL = ITEMS.register("bubblium_chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));
    public static final DeferredItem<Item> PULL = ITEMS.register("pull",
            () -> new MaginItem(new Item.Properties()));
    public static final DeferredItem<Item> LAUNCH = ITEMS.register("launch",
            () -> new SytheItem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> HEAL = ITEMS.register("heal",
            () -> new MagicItem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
