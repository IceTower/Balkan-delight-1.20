package net.omegasleepy.bubl.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.omegasleepy.bubl.Config;
import net.omegasleepy.bubl.block.ModBlocks;
import net.omegasleepy.bubl.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class MagicBlock extends Block {
    public MagicBlock (Properties properties) {
        super(properties);
    }


    @Override
    protected InteractionResult useWithoutItem (BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {


        level.playSound(player,pos, SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.BLOCKS,1f,1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn (Level level, BlockPos pos, BlockState state, Entity entity) {
//        if (entity instanceof ItemEntity itemEntity){
//            if(itemEntity.getItem().getItem() == ModItems.RAW_BUBBLIUM.get()){
//                itemEntity.setItem(new ItemStack(Items.DIAMOND,itemEntity.getItem().getCount()));
//            }
//            if(itemEntity.getItem().getItem() == Items.DANDELION){
//                itemEntity.setItem(new ItemStack(ModBlocks.BUBBLIUM_BLOCK,itemEntity.getItem().getCount()));
//            }
//        }
        float yaw = entity.getYRot() * ((float)Math.PI / 180F);
        float pitch = entity.getXRot() * ((float)Math.PI / 180F);

        double dx = -Math.sin(yaw);
        double dz =  Math.cos(yaw);

        double HmultiP = Config.HORIZONTAL_PUSH.getAsDouble();
        double VmultiP = Config.VERTICAL_PUSH.getAsDouble();

        double dy = -Math.sin(pitch);

//        if(entity.isCrouching()){
            entity.setDeltaMovement(entity.getDeltaMovement().add(dx*HmultiP,dy*VmultiP+0.8f,dz*HmultiP));
//        }

        super.stepOn(level, pos, state, entity);
    }

//    @Override
//    public float getFriction (BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) {
//        assert entity != null;
//        float friction = 1f;
//        if(entity.isCrouching()) {
//            friction = 0.5f;
//        }
//        return friction;
//    }


}
