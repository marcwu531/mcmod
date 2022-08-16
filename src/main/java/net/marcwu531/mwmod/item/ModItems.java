package net.marcwu531.mwmod.item;

import net.marcwu531.mwmod.MWMod;
import net.marcwu531.mwmod.item.custom.Fire_mushroom;
import net.marcwu531.mwmod.item.custom.Mushroom_ingot;
import net.minecraft.client.gui.fonts.TexturedGlyph;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.potion.Effects;
import net.minecraft.tags.Tag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MWMod.MOD_ID);

    public static final RegistryObject<Item> MUSHROOM = ITEMS.register("mushroom",
            () -> new Item(new Item.Properties()
                    .food((new Food.Builder()).hunger(1).saturation(0.1f)
                            .effect(() -> new EffectInstance(Effects.SATURATION, 20, 2), 0.5f)
                            .effect(() -> new EffectInstance(Effects.POISON, 200, 4), 0.5f)
                            .fastToEat().setAlwaysEdible().build())
                    .group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_INGOT = ITEMS.register("mushroom_ingot",
            () -> new Mushroom_ingot(new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_BOOTS = ITEMS.register("mushroom_boots",
            () -> new ArmorItem(ModArmorMaterial.MUSHROOM, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_CHESTPLATE = ITEMS.register("mushroom_chestplate",
            () -> new ArmorItem(ModArmorMaterial.MUSHROOM, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_LEGGINGS = ITEMS.register("mushroom_leggings",
            () -> new ArmorItem(ModArmorMaterial.MUSHROOM, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_HELMET = ITEMS.register("mushroom_helmet",
            () -> new ArmorItem(ModArmorMaterial.MUSHROOM, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));
//atkdmg+1, atkspd+0.1(f)
    public static final RegistryObject<Item> MUSHROOM_SWORD = ITEMS.register("mushroom_sword",
            () -> new SwordItem(ModItemTier.MUSHROOM,4,-2.3f,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_PICKAXE = ITEMS.register("mushroom_pickaxe",
            () -> new PickaxeItem(ModItemTier.MUSHROOM,2,-2.7f,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_SHOVEL = ITEMS.register("mushroom_shovel",
            () -> new ShovelItem(ModItemTier.MUSHROOM,2.5f,-2.9f,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_AXE = ITEMS.register("mushroom_axe",
            () -> new AxeItem(ModItemTier.MUSHROOM,6,-3,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_HOE = ITEMS.register("mushroom_hoe",
            () -> new HoeItem(ModItemTier.MUSHROOM,-4,0.1f,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> FIRE_MUSHROOM = ITEMS.register("fire_mushroom",
            () -> new Fire_mushroom(new Item.Properties()
                    .food((new Food.Builder()).hunger(1).saturation(0.1f)
                            .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 200, 4), 0.25f)
                            .effect(() -> new EffectInstance(Effects.POISON, 200, 4), 0.5f)
                            .effect(() -> new EffectInstance(Effects.WITHER, 200, 4), 0.5f)
                            .fastToEat().setAlwaysEdible().build())
                    .group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_WOODEN_INGOT = ITEMS.register("mushroom_wooden_ingot",
            () -> new Item(new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_WOODEN_SWORD = ITEMS.register("mushroom_wooden_sword",
            () -> new SwordItem(ModItemTier.WOODEN, 5, -2,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_WOODEN_PICKAXE = ITEMS.register("mushroom_wooden_pickaxe",
            () -> new PickaxeItem(ModItemTier.WOODEN, 3, -2,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_WOODEN_SHOVEL = ITEMS.register("mushroom_wooden_shovel",
            () -> new ShovelItem(ModItemTier.WOODEN, 3, -2,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_WOODEN_AXE = ITEMS.register("mushroom_wooden_axe",
            () -> new AxeItem(ModItemTier.WOODEN, 7, -3,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_WOODEN_HOE = ITEMS.register("mushroom_wooden_hoe",
            () -> new HoeItem(ModItemTier.WOODEN, -3, 1,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_WOODEN_BOOTS = ITEMS.register("mushroom_wooden_boots",
            () -> new ArmorItem(ModArmorMaterial.WOODEN, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_WOODEN_CHESTPLATE = ITEMS.register("mushroom_wooden_chestplate",
            () -> new ArmorItem(ModArmorMaterial.WOODEN, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_WOODEN_LEGGINGS = ITEMS.register("mushroom_wooden_leggings",
            () -> new ArmorItem(ModArmorMaterial.WOODEN, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));

    public static final RegistryObject<Item> MUSHROOM_WOODEN_HELMET = ITEMS.register("mushroom_wooden_helmet",
            () -> new ArmorItem(ModArmorMaterial.WOODEN, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.MWMOD_GROUP)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
