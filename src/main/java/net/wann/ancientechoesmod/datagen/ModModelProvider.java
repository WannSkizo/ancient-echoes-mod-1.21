package net.wann.ancientechoesmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.wann.ancientechoesmod.block.ModBlocks;
import net.wann.ancientechoesmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADAMANTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRIMORDIAL_STEEL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUANTUM_FORGE);

        blockStateModelGenerator.registerLog(ModBlocks.FAEVIL_LOG).log(ModBlocks.FAEVIL_LOG).wood(ModBlocks.FAEVIL_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_FAEVIL_LOG).log(ModBlocks.STRIPPED_FAEVIL_LOG).wood(ModBlocks.STRIPPED_FAEVIL_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FAEVIL_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.FAEVIL_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.FAEVIL_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_ADAMANTIUM_ORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAMANTIUM_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAMANTIUM_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAMANTIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_VIBRANIUM_ORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_STICK, Models.GENERATED);

        itemModelGenerator.register(ModItems.ADAMANTIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_AXE, Models.HANDHELD);
    }
}
