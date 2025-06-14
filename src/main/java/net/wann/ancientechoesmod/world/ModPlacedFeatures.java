package net.wann.ancientechoesmod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.wann.ancientechoesmod.AncientEchoesMod;
import net.wann.ancientechoesmod.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ORE_ADAMANTIUM_SMALL_PLACED = registerKey("ore_adamantium_small_placed");
    public static final RegistryKey<PlacedFeature> ORE_ADAMANTIUM_MEDIUM_PLACED = registerKey("ore_adamantium_medium_placed");
    public static final RegistryKey<PlacedFeature> ORE_ADAMANTIUM_LARGE_PLACED = registerKey("ore_adamantium_large_placed");
    public static final RegistryKey<PlacedFeature> ORE_ADAMANTIUM_BURIED_PLACED = registerKey("ore_adamantium_buried_placed");

    public static final RegistryKey<PlacedFeature> ORE_VIBRANIUM_SMALL_PLACED = registerKey("ore_vibranium_small_placed");
    public static final RegistryKey<PlacedFeature> ORE_VIBRANIUM_MEDIUM_PLACED = registerKey("ore_vibranium_medium_placed");
    public static final RegistryKey<PlacedFeature> ORE_VIBRANIUM_LARGE_PLACED = registerKey("ore_vibranium_large_placed");
    public static final RegistryKey<PlacedFeature> ORE_VIBRANIUM_EXTRA_LARGE_BURIED_PLACED = registerKey("ore_vibranium_extra_large_buried_placed");

    public static final RegistryKey<PlacedFeature> ORE_COAL_PLACED = registerKey("ore_coal_placed");
    public static final RegistryKey<PlacedFeature> ORE_COAL_BURIED_PLACED = registerKey("ore_coal_buried_placed");

    public static final RegistryKey<PlacedFeature> ORE_IRON_PLACED = registerKey("ore_iron_placed");
    public static final RegistryKey<PlacedFeature> ORE_IRON_SMALL_PLACED = registerKey("ore_iron_small_placed");

    public static final RegistryKey<PlacedFeature> ORE_REDSTONE_PLACED = registerKey("ore_redstone_placed");

    public static final RegistryKey<PlacedFeature> PRIMORDIAL_STEEL_SMALL_PLACED = registerKey("primordial_steel_small_placed");
    public static final RegistryKey<PlacedFeature> PRIMORDIAL_STEEL_LARGE_PLACED = registerKey("primordial_steel_large_placed");

    public static final RegistryKey<PlacedFeature> FAEVILWOOD_PLACED = registerKey("faevilwood_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, ORE_ADAMANTIUM_SMALL_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_ADAMANTIUM_SMALL),
                ModOrePlacement.modifiersWithCount(7,
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
        register(context, ORE_ADAMANTIUM_MEDIUM_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_ADAMANTIUM_MEDIUM),
                ModOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-4))));
        register(context, ORE_ADAMANTIUM_LARGE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_ADAMANTIUM_LARGE),
                ModOrePlacement.modifiersWithRarity(9,
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
        register(context, ORE_ADAMANTIUM_BURIED_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_ADAMANTIUM_BURIED),
                ModOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));

        register(context, ORE_VIBRANIUM_SMALL_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_VIBRANIUM_SMALL),
                ModOrePlacement.modifiersWithCount(70,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.getTop())));
        register(context, ORE_VIBRANIUM_MEDIUM_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_VIBRANIUM_MEDIUM),
                ModOrePlacement.modifiersWithCount(50,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(10), YOffset.getTop())));
        register(context, ORE_VIBRANIUM_LARGE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_VIBRANIUM_LARGE),
                ModOrePlacement.modifiersWithCount(25,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(10), YOffset.getTop())));
        register(context, ORE_VIBRANIUM_EXTRA_LARGE_BURIED_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_VIBRANIUM_EXTRA_LARGE_BURIED),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(12), YOffset.fixed(55))));

        register(context, ORE_COAL_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_COAL),
                ModOrePlacement.modifiersWithCount(30,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(136), YOffset.getTop())));
        register(context, ORE_COAL_BURIED_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_COAL_BURIED),
                ModOrePlacement.modifiersWithCount(20,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(192))));

        register(context, ORE_IRON_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_VIBRANIUM_SMALL),
                ModOrePlacement.modifiersWithCount(90,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(80), YOffset.getTop())));
        register(context, ORE_IRON_SMALL_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_VIBRANIUM_MEDIUM),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(72))));

        register(context, ORE_REDSTONE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_VIBRANIUM_SMALL),
                ModOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(30))));

        register(context, PRIMORDIAL_STEEL_SMALL_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.PRIMORDIAL_STEEL_SMALL),
                ModSquarePlacement.of(),
                PlacedFeatures.EIGHT_ABOVE_AND_BELOW_RANGE, BiomePlacementModifier.of());

        register(context, PRIMORDIAL_STEEL_LARGE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.PRIMORDIAL_STEEL_LARGE),
                ModSquarePlacement.of(),
                HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(24)), BiomePlacementModifier.of());

        register(context, FAEVILWOOD_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.FAEVILWOOD),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1F, 2), ModBlocks.FAEVIL_SAPLING));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(AncientEchoesMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}