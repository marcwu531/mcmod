package net.marcwu531.mwmod.block.custom;

import net.marcwu531.mwmod.item.custom.Fire_mushroom;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Fire_mushroom_block extends Block {
    public Fire_mushroom_block(Properties properties) {
        super(properties);
    }



    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        Fire_mushroom.lightEntityOnFire(entityIn, 5);

        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
