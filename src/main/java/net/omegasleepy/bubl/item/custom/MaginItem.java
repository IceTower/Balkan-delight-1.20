package net.omegasleepy.bubl.item.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MaginItem extends Item {
    public MaginItem (Properties properties) {
        super(properties);
    }

    @Override
    public boolean onLeftClickEntity (ItemStack stack, Player player, Entity entity) {

        float yaw = player.getYRot() * ((float)Math.PI / 180F);

        double dx = -Math.sin(yaw);
        double dz =  Math.cos(yaw);

        entity.setDeltaMovement(entity.getDeltaMovement().add(-dx,0.1,-dz));

        return super.onLeftClickEntity(stack, player, entity);
    }
}
