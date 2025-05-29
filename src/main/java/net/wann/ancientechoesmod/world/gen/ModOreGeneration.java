package net.wann.ancientechoesmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.wann.ancientechoesmod.world.ModPlacedFeatures;
import net.wann.ancientechoesmod.world.biome.ModBiomes;

public class ModOreGeneration {
    public static void generatedOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.ORE_ADAMANTIUM_SMALL_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.ORE_ADAMANTIUM_MEDIUM_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.ORE_ADAMANTIUM_LARGE_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.ORE_ADAMANTIUM_BURIED_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.VIBRA_BIOME), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.ORE_VIBRANIUM_SMALL_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.VIBRA_BIOME), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.ORE_VIBRANIUM_MEDIUM_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.VIBRA_BIOME), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.ORE_VIBRANIUM_LARGE_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_DECORATION,
                ModPlacedFeatures.PRIMORDIAL_STEEL_SMALL_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_DECORATION,
                ModPlacedFeatures.PRIMORDIAL_STEEL_LARGE_PLACED);
    }
}
