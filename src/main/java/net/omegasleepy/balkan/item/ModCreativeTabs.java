package net.omegasleepy.balkan.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.omegasleepy.balkan.TutorialMod;
import net.omegasleepy.balkan.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BALKAN_ITEMS = CREATIVE_MODE_TAB.register("funky_items",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BUBBLIUM.get()))
                    .title(Component.translatable("creativetab.balkan.funky_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BUBBLIUM);
                        output.accept(ModItems.PIRIUM);
                        output.accept(ModItems.LOVIUM);
                        output.accept(ModItems.SUNIUM);
                        output.accept(ModItems.TRENIUM);
                        output.accept(ModItems.RAW_BUBBLIUM);
                    }).build());

    public static final Supplier<CreativeModeTab> BALKAN_BLOCKS = CREATIVE_MODE_TAB.register("funky_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.WHITE_PLANS.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,"funky_items"))
                    .title(Component.translatable("creativetab.balkan.funky_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.WHITE_PLANS);
                        output.accept(ModBlocks.CYAN_PLANKS);
                        output.accept(ModBlocks.BUBBLIUM_BLOCK);
                        output.accept(ModBlocks.BUBBLIUM_ORE);
                        output.accept(ModBlocks.BUBBLIUM_DEEPSLATE_ORE);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
