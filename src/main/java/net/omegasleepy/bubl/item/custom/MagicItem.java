package net.omegasleepy.bubl.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MagicItem extends Item {
    public MagicItem (Properties properties) {
        super(properties);
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        int flevel = player.getFoodData().getFoodLevel();

        if (player instanceof LivingEntity living) {
            living.heal(3f);
            if (flevel<10){
                player.getFoodData().setFoodLevel(flevel+2);
            }

        }

        player.getCooldowns().addCooldown(this, 40);

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
