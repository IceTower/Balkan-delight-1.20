package net.omegasleepy.bubl;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();


    public static final ModConfigSpec.IntValue MAGIC_NUMBER = BUILDER
            .comment("A magic number")
            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue HORIZONTAL_PUSH = BUILDER
            .comment("The amount of force that the magic block will push in the horizontal direction")
            .defineInRange("horizontalPush",1.5f,0,10f);

    public static final ModConfigSpec.DoubleValue VERTICAL_PUSH = BUILDER
            .comment("The amount of force that the magic block will push in the vertical direction")
            .defineInRange("verticalPush",1.5f,0,10f);


    static final ModConfigSpec SPEC = BUILDER.build();

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }
}
