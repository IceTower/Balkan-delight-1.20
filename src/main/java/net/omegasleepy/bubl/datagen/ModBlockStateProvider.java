package net.omegasleepy.bubl.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.omegasleepy.bubl.TutorialMod;
import net.omegasleepy.bubl.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider (PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels () {
        blockWithItem(ModBlocks.BUBBLIUM_BLOCK);
        blockWithItem(ModBlocks.BUBBLIUM_BRICKS);
        blockWithItem(ModBlocks.SMALL_LAUNCH);
        blockWithItem(ModBlocks.BUBBLIUM_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.BUBBLIUM_ORE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
