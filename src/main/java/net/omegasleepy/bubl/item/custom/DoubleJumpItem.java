package net.omegasleepy.bubl.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DoubleJumpItem extends Item {
    public DoubleJumpItem (Properties properties) {
        super(properties);
    }

    boolean doublJ = false;

    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if(player.onGround()){
            doublJ = true;
        }

        if(doublJ) {
            player.setDeltaMovement(player.getDeltaMovement().add(0,1,0));
            doublJ = false;
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
