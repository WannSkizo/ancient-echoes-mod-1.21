package net.wann.ancientechoesmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.wann.ancientechoesmod.datagen.ModBlockTagProvider;
import net.wann.ancientechoesmod.datagen.ModLootTableProvider;
import net.wann.ancientechoesmod.datagen.ModModelProvider;
import net.wann.ancientechoesmod.datagen.ModRecipeProvider;
import net.wann.ancientechoesmod.datagen.ModWorldGenerator;
import net.wann.ancientechoesmod.world.ModConfiguredFeatures;
import net.wann.ancientechoesmod.world.ModPlacedFeatures;
import net.wann.ancientechoesmod.world.biome.ModBiomes;
import net.wann.ancientechoesmod.world.dimension.ModDimension;

public class AncientEchoesModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.DIMENSION_TYPE, ModDimension::bootstrapType);
	}
}
