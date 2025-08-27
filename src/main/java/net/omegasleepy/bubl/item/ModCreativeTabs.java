package net.omegasleepy.bubl.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.omegasleepy.bubl.TutorialMod;
import net.omegasleepy.bubl.block.ModBlocks;
import org.apache.http.conn.routing.RouteTracker;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BUBL_ITEMS = CREATIVE_MODE_TAB.register("funky_items",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BUBBLIUM.get()))
                    .title(Component.translatable("creativetab.bubl.funky_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BUBBLIUM);
                        output.accept(ModItems.RAW_BUBBLIUM);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.PULL);
                        output.accept(ModItems.LAUNCH);
                        output.accept(ModItems.HEAL);
                    }).build());

    public static final Supplier<CreativeModeTab> BUBL_BLOCKS = CREATIVE_MODE_TAB.register("funky_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BUBBLIUM_ORE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,"funky_items"))
                    .title(Component.translatable("creativetab.bubl.funky_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.BUBBLIUM_BLOCK);
                        output.accept(ModBlocks.BUBBLIUM_ORE);
                        output.accept(ModBlocks.BUBBLIUM_DEEPSLATE_ORE);
                        output.accept(ModBlocks.BUBBLIUM_BRICKS);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
