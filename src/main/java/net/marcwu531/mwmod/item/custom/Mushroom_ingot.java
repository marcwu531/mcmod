package net.marcwu531.mwmod.item.custom;

import net.marcwu531.mwmod.block.ModBlocks;
import net.marcwu531.mwmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class Mushroom_ingot extends Item {

    public Mushroom_ingot(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();

        if (!world.isRemote) {
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());
            BlockState clickedBlock = world.getBlockState(context.getPos());

            rightClickOnCertainBlockState(clickedBlock, context, playerEntity);
            stack.damageItem(1, playerEntity,
                    player -> player.sendBreakAnimation(context.getHand()));
        }

        return super.onItemUseFirst(stack, context);
    }

    private void rightClickOnCertainBlockState(BlockState clickedBlock, ItemUseContext context,
                                               PlayerEntity playerEntity) {

        //if(playerEntity.isPotionActive(Effects.FIRE_RESISTANCE)) return;

        //if (random.nextFloat() > 0.5f) {
            //LightningBoltEntity lightningboltentity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, context.getWorld());
            //Entity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, context.getWorld());
            //summonlightning()

        /*} else */if (blockIsWood(clickedBlock)) {
            gainWood(playerEntity, context.getWorld(), context.getPos());
        }
    }

    private boolean blockIsWood(BlockState clickedBlock) {
        return clickedBlock.getBlock() == ModBlocks.WOOD_BLOCK.get();
    }

    /*public static void lightEntityOnBolt(Entity entity, ServerWorld world, LightningBoltEntity lightning) {
        entity.causeLightningStrike((ServerWorld)world, lightning);
    }*/

    private void gainWood(PlayerEntity playerEntity, World world,
                                                   BlockPos pos) {
        world.destroyBlock(pos, false);
                int slot = playerEntity.inventory.currentItem;
                int origin = playerEntity.inventory.getCurrentItem().getCount();
                playerEntity.replaceItemInInventory(slot, ItemStack.EMPTY.getContainerItem());
                playerEntity.addItemStackToInventory(ModItems.MUSHROOM_WOODEN_INGOT.get().getDefaultInstance());
        for (int i = 0; i < (origin-1); i++) {
            playerEntity.addItemStackToInventory(ModItems.MUSHROOM_INGOT.get().getDefaultInstance());
        }
    }
}