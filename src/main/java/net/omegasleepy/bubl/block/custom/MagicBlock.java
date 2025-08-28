package net.omegasleepy.bubl.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class MagicBlock extends Block {

    // fields you can pass in
    private final double hMultiplier;
    private final double vMultiplier;

    public MagicBlock(Properties properties, double hMultiplier, double vMultiplier) {
        super(properties);
        this.hMultiplier = hMultiplier;
        this.vMultiplier = vMultiplier;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        float yaw = entity.getYRot() * ((float) Math.PI / 180F);
        float pitch = entity.getXRot() * ((float) Math.PI / 180F);

        double dx = -Math.sin(yaw);
        double dz =  Math.cos(yaw);
        double dy = -Math.sin(pitch);

        entity.setDeltaMovement(entity.getDeltaMovement().add(
                dx * hMultiplier,
                dy * vMultiplier + 0.8f,
                dz * hMultiplier
        ));

        super.stepOn(level, pos, state, entity);
    }
}
