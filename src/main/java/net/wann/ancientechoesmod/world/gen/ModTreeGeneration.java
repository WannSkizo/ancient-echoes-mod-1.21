package net.wann.ancientechoesmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.wann.ancientechoesmod.world.ModPlacedFeatures;
import net.wann.ancientechoesmod.world.biome.ModBiomes;

public class ModTreeGeneration {
    public static void generatedTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.VIBRA_BIOME),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FAEVILWOOD_PLACED);
    }
}
