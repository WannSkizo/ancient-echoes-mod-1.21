package net.wann.ancientechoesmod.world.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.world.dimension.DimensionOptions;
import net.wann.ancientechoesmod.world.dimension.ModDimension;

import java.util.function.Predicate;

public class ModBiomeSelectors {	/**
 * Returns a biome selector that will match all biomes that would normally spawn in the Overworld,
 * assuming Vanilla's default biome source is used.
 */
public static Predicate<BiomeSelectionContext> foundInVibralune() {
    return context -> context.canGenerateIn(ModDimension.VIBRALUNE);
}
}
