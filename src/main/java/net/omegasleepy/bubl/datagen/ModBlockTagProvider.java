package net.omegasleepy.bubl.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.omegasleepy.bubl.TutorialMod;
import net.omegasleepy.bubl.block.ModBlocks;
import net.omegasleepy.bubl.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider (PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags (HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BUBBLIUM_BLOCK.get())
                .add(ModBlocks.SMALL_LAUNCH.get())
                .add(ModBlocks.BUBBLIUM_ORE.get())
                .add(ModBlocks.BUBBLIUM_BRICKS.get())
                .add(ModBlocks.BUBBLIUM_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BUBBLIUM_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BUBBLIUM_DEEPSLATE_ORE.get());
    }
}
