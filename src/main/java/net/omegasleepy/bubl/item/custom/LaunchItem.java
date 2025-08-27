package net.omegasleepy.bubl.item.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class LaunchItem extends Item {
    public LaunchItem (Properties properties) {
        super(properties);
    }

    @Override
    public boolean onLeftClickEntity (ItemStack stack, Player player, Entity entity) {

        entity.setDeltaMovement(entity.getDeltaMovement().add(0,0.87,0));

        return super.onLeftClickEntity(stack, player, entity);
    }
}
