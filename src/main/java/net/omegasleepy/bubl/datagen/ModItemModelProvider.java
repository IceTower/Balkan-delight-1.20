package net.omegasleepy.bubl.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.omegasleepy.bubl.TutorialMod;
import net.omegasleepy.bubl.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider (PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels () {
        basicItem(ModItems.RAW_BUBBLIUM.get());
        basicItem(ModItems.DOUBLEJ.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.BUTTER.get());
        basicItem(ModItems.BUBBLIUM.get());
        basicItem(ModItems.HEAL.get());
        basicItem(ModItems.HUNGER.get());
        basicItem(ModItems.LAUNCH.get());
        basicItem(ModItems.PULL.get());
        basicItem(ModItems.STAR_OF_FLAMES.get());
    }
}

