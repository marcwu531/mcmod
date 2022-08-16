package net.marcwu531.mwmod.block;

import net.marcwu531.mwmod.MWMod;
import net.marcwu531.mwmod.block.custom.Fire_mushroom_block;
import net.marcwu531.mwmod.block.custom.trees.MushroomTree;
import net.marcwu531.mwmod.item.ModItemGroup;
import net.marcwu531.mwmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, MWMod.MOD_ID);

    public static final RegistryObject<Block> MUSHROOM_MIXTURE = registerBlock("mushroom_mixture",
            () -> new LeavesBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.HOE).hardnessAndResistance(1f).tickRandomly().notSolid()),"");

    public static final RegistryObject<Block> MUSHROOM_ORE = registerBlock("mushroom_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3f)),"");

    public static final RegistryObject<Block> MUSHROOM_BLOCK = registerBlock("mushroom_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)),"");

    public static final RegistryObject<Block> GU_BLOCK = registerBlock("gu_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f))
    ,"tooltip.mwmod.gu_block");

    public static final RegistryObject<Block> WOOD_BLOCK = registerBlock("wood_block",
            () -> new Block(AbstractBlock.Properties.create(Material.WOOD)
                    .harvestLevel(0).harvestTool(ToolType.AXE).setRequiresTool().hardnessAndResistance(3f)),"");

    public static final RegistryObject<Block> MUSHROOM_WOODEN_BLOCK = registerBlock("mushroom_wooden_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(4f)),"");

    public static final RegistryObject<Block> FIRE_MUSHROOM_BLOCK = registerBlock("fire_mushroom_block",
            () -> new Fire_mushroom_block(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f))
            ,"tooltip.mwmod.fire_mushroom_block");

    public static final RegistryObject<Block> MUSHROOM_SAPLING = registerBlock("mushroom_sapling",
            () -> new SaplingBlock(new MushroomTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)),"");
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.MWMOD_GROUP)) {
            @Override
            public void addInformation(ItemStack stack, @Nullable World worldIn
                    , List<ITextComponent> tooltip, ITooltipFlag flagIn) {
                if(!tooltipKey.equals("")) {
                    tooltip.add(new TranslationTextComponent(tooltipKey));
                }
                super.addInformation(stack, worldIn, tooltip, flagIn);
            }
        });
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
