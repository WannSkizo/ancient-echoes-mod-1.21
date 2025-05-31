package net.wann.ancientechoesmod.world;

import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.wann.ancientechoesmod.AncientEchoesMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.wann.ancientechoesmod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ADAMANTIUM_SMALL = registerKey("ore_adamantium_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ADAMANTIUM_MEDIUM = registerKey("ore_adamantium_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ADAMANTIUM_LARGE = registerKey("ore_adamantium_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ADAMANTIUM_BURIED = registerKey("ore_adamantium_buried");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_VIBRANIUM_SMALL = registerKey("ore_vibranium_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_VIBRANIUM_MEDIUM = registerKey("ore_vibranium_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_VIBRANIUM_LARGE = registerKey("ore_vibranium_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_VIBRANIUM_EXTRA_LARGE_BURIED = registerKey("ore_vibranium_extra_large_buried");

    public static final RegistryKey<ConfiguredFeature<?, ?>> PRIMORDIAL_STEEL_SMALL = registerKey("primordial_steel_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PRIMORDIAL_STEEL_LARGE = registerKey("primordial_steel_large");

    public static final RegistryKey<ConfiguredFeature<?,  ?>> FAEVILWOOD = registerKey("faevilwood");

    public static TreeFeatureConfig.Builder faevil() {
        return new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.FAEVIL_LOG),
                new CherryTrunkPlacer(
                        7,
                        1,
                        0,
                        new WeightedListIntProvider(
                                DataPool.<IntProvider>builder().add(ConstantIntProvider.create(1), 1).add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(3), 1).build()
                        ),
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(-4, -3),
                        UniformIntProvider.create(-1, 0)
                ),
                BlockStateProvider.of(ModBlocks.FAEVIL_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
                new TwoLayersFeatureSize(1, 0, 2)
        )
                .ignoreVines();
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest ruleList1 = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest ruleList2 = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest ruleList3 = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> list1 =
                List.of(OreFeatureConfig.createTarget(ruleList1, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> list2 =
                List.of(OreFeatureConfig.createTarget(ruleList2, ModBlocks.VIBRANIUM_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> list3 =
                List.of(OreFeatureConfig.createTarget(ruleList3, ModBlocks.PRIMORDIAL_STEEL.getDefaultState()));

        register(context, ORE_ADAMANTIUM_SMALL, Feature.ORE, new OreFeatureConfig(list1, 3, 0.5F));
        register(context, ORE_ADAMANTIUM_MEDIUM, Feature.ORE, new OreFeatureConfig(list1, 6, 0.5F));
        register(context, ORE_ADAMANTIUM_LARGE, Feature.ORE, new OreFeatureConfig(list1, 10, 0.7F));
        register(context, ORE_ADAMANTIUM_BURIED, Feature.ORE, new OreFeatureConfig(list1, 6, 1.0F));

        register(context, ORE_VIBRANIUM_SMALL, Feature.ORE, new OreFeatureConfig(list2, 6, 0.1F));
        register(context, ORE_VIBRANIUM_MEDIUM, Feature.ORE, new OreFeatureConfig(list2, 9, 0.2F));
        register(context, ORE_VIBRANIUM_LARGE, Feature.ORE, new OreFeatureConfig(list2, 12, 0.5F));
        register(context, ORE_VIBRANIUM_EXTRA_LARGE_BURIED, Feature.ORE, new OreFeatureConfig(list2, 24, 0.97F));

        register(context, PRIMORDIAL_STEEL_SMALL, Feature.SCATTERED_ORE, new OreFeatureConfig(list3, 2, 1.0F));
        register(context, PRIMORDIAL_STEEL_LARGE, Feature.SCATTERED_ORE, new OreFeatureConfig(list3, 3, 1.0F));

        register(context, FAEVILWOOD, Feature.TREE, faevil().build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(AncientEchoesMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

