package net.wann.ancientechoesmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.wann.ancientechoesmod.block.ModBlocks;
import net.wann.ancientechoesmod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_BLOCK)
                .add(ModBlocks.PRIMORDIAL_STEEL)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.VIBRA_PORTAL);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(ModTags.Blocks.NEEDS_ADAMANTIUM_TOOL);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(ModTags.Blocks.NEEDS_ADAMANTIUM_TOOL);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(ModTags.Blocks.NEEDS_ADAMANTIUM_TOOL);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(ModTags.Blocks.NEEDS_ADAMANTIUM_TOOL);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(ModTags.Blocks.NEEDS_ADAMANTIUM_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.ADAMANTIUM_BLOCK)
                .add(ModBlocks.PRIMORDIAL_STEEL);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .addTag(ModTags.Blocks.NEEDS_ADAMANTIUM_TOOL);


        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ADAMANTIUM_TOOL)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.VIBRA_PORTAL);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_ADAMANTIUM_TOOL)
                ;

        getOrCreateTagBuilder(ModTags.Blocks.VIBRA_STONE_ORE_REPLACEABLES)
                .add(ModBlocks.VIBRA_STONE)
                .add(Blocks.GRANITE)
                .add(Blocks.DIORITE)
                .add(Blocks.ANDESITE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.FAEVIL_LOG)
                .add(ModBlocks.FAEVIL_WOOD)
                .add(ModBlocks.STRIPPED_FAEVIL_LOG)
                .add(ModBlocks.STRIPPED_FAEVIL_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.FAEVIL_PLANKS);

        //getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.PINK_GARNET_FENCE);
        //getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.PINK_GARNET_FENCE_GATE);
        //getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.PINK_GARNET_WALL);
    }
}