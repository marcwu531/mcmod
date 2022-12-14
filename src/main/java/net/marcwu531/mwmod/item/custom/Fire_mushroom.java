package net.marcwu531.mwmod.item.custom;

import net.marcwu531.mwmod.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class Fire_mushroom extends Item {

    public Fire_mushroom(Properties properties) {
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

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn
            , List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.mwmod.fire_mushroom_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.mwmod.fire_mushroom"));
        }
    }

    private void rightClickOnCertainBlockState(BlockState clickedBlock, ItemUseContext context,
                                               PlayerEntity playerEntity) {

        boolean playerIsNotOnFire = !playerEntity.isBurning();

        if(playerEntity.isPotionActive(Effects.FIRE_RESISTANCE)) return;

        if (random.nextFloat() > 0.5f) {
            lightEntityOnFire(playerEntity,5);

        } else if (playerIsNotOnFire && blockIsValidForResistance(clickedBlock)) {
            gainFireResistanceAndDestroyBlock(playerEntity, context.getWorld(), context.getPos());
        } else {
            lightGroundOnFire(context);
        }

    }

    private boolean blockIsValidForResistance(BlockState clickedBlock) {
        return clickedBlock.getBlock() == ModBlocks.GU_BLOCK.get();
    }

    public static void lightEntityOnFire(Entity entity, int second) {
        entity.setFire(second);
    }

    private void gainFireResistanceAndDestroyBlock(PlayerEntity playerEntity, World world,
                                                   BlockPos pos) {
        gainFireResistance(playerEntity);
        world.destroyBlock(pos, false);
    }

    public static void gainFireResistance(PlayerEntity playerEntity) {
        playerEntity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE
                ,20000000,4));
        // dur/20 = sec
    }

    public static void lightGroundOnFire(ItemUseContext context) {

        PlayerEntity playerentity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockpos = context.getPos().offset(context.getFace());

        if (AbstractFireBlock.canLightBlock(world, blockpos, context.getPlacementHorizontalFacing())) {
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE,
                    SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);

            BlockState blockstate = AbstractFireBlock.getFireForPlacement(world, blockpos);
            world.setBlockState(blockpos, blockstate, 11);
        }
    }
}
