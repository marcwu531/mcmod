package net.marcwu531.mwmod.world.gen;

import net.marcwu531.mwmod.block.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    //  Features
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MUSHROOM =
            register("mushroom", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.WOOD_BLOCK.get().getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.MUSHROOM_MIXTURE.get().getDefaultState()),
                            new BlobFoliagePlacer(FeatureSpread.create(2),
                                    FeatureSpread.create(0), 3),
                            new StraightTrunkPlacer(6, 2, 0),
                            new TwoLayerFeature(1, 0, 1)))
                    .setIgnoreVines().build()));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
