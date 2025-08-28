package net.omegasleepy.bubl.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.omegasleepy.bubl.Config;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SytheItem extends Item {
    public SytheItem (Properties properties) {
        super(properties);
    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        float yaw = player.getYRot() * ((float)Math.PI / 180F);
        float pitch = player.getXRot() * ((float)Math.PI / 180F);

        double dx = -Math.sin(yaw);
        double dz =  Math.cos(yaw);

        double HmultiP = Config.HORIZONTAL_PUSH.getAsDouble();
        double VmultiP = Config.VERTICAL_PUSH.getAsDouble();

        double dy = -Math.sin(pitch);

        player.setDeltaMovement(player.getDeltaMovement().add(dx*HmultiP*1.5f,dy*VmultiP+0.8f,dz*HmultiP*1.5f));

        player.getCooldowns().addCooldown(this, 15);

        level.playSound(player,player,SoundEvents.WIND_CHARGE_THROW,SoundSource.PLAYERS,1,1);

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public void appendHoverText (ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasAltDown()) {
            tooltipComponents.add(Component.translatable("tooltip.bubl.sythe.tooltip"));
        } else{
            tooltipComponents.add(Component.translatable("tooltip.bubl.sythe.nottip"));
        }


        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
