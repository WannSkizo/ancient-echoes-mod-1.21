package net.wann.ancientechoesmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import net.wann.ancientechoesmod.block.ModBlocks;
import net.wann.ancientechoesmod.block.entity.ModBlockEntities;
import net.wann.ancientechoesmod.item.ModItems;
import net.wann.ancientechoesmod.recipe.ModRecipes;
import net.wann.ancientechoesmod.screen.ModScreenHandlers;
import net.wann.ancientechoesmod.util.ModLootTableModifiers;
import net.wann.ancientechoesmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AncientEchoesMod implements ModInitializer {
	public static final String MOD_ID = "ancientechoesmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModBlockEntities.registerBlockEntitie();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		ModWorldGeneration.generatedModWorldGen();

		ModLootTableModifiers.modifyLootTable();

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.VIBRA_PORTAL)
				.destDimID(Identifier.of(AncientEchoesMod.MOD_ID, "vibralune"))
				.tintColor(113, 30, 166)
				.registerPortal();

		StrippableBlockRegistry.register(ModBlocks.FAEVIL_LOG, ModBlocks.STRIPPED_FAEVIL_LOG);
		StrippableBlockRegistry.register(ModBlocks.FAEVIL_LOG, ModBlocks.STRIPPED_FAEVIL_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FAEVIL_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FAEVIL_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_FAEVIL_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_FAEVIL_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FAEVIL_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FAEVIL_LEAVES, 30, 60);

	}
}