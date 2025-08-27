package net.omegasleepy.bubl.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.omegasleepy.bubl.TutorialMod;
import net.omegasleepy.bubl.block.custom.MagicBlock;
import net.omegasleepy.bubl.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TutorialMod.MOD_ID);

    public static final DeferredBlock<Block> BUBBLIUM_ORE = registerBlock("bubblium_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().friction(1f).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BUBBLIUM_DEEPSLATE_ORE = registerBlock("bubblium_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().friction(1f).sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> BUBBLIUM_BLOCK = registerBlock("bubblium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().friction(1.001f).strength(2f).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BUBBLIUM_BRICKS = registerBlock("bubblium_bricks",
            () -> new MagicBlock(BlockBehaviour.Properties.of().friction(1.002f).strength(2f).sound(SoundType.TUFF_BRICKS)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
