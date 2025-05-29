package net.wann.ancientechoesmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.wann.ancientechoesmod.AncientEchoesMod;
import net.wann.ancientechoesmod.block.ModBlocks;
import net.wann.ancientechoesmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> ADAMANTIUM_SHARD = List.of(ModItems.RAW_ADAMANTIUM_ORE, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
        List<ItemConvertible> ADAMANTIUM_SCRAP = List.of(ModBlocks.PRIMORDIAL_STEEL);

        offerSmelting(exporter, ADAMANTIUM_SHARD,
                RecipeCategory.MISC, ModItems.ADAMANTIUM_SHARD, 1.3f, 200, "adamantium_shard");
        offerSmelting(exporter, ADAMANTIUM_SCRAP,
                RecipeCategory.MISC, ModItems.ADAMANTIUM_SCRAP, 2.3f, 200, "adamantium_scrap");

        offerBlasting(exporter, ADAMANTIUM_SHARD,
                RecipeCategory.MISC, ModItems.ADAMANTIUM_SHARD, 1.3f, 100, "adamantium_shard");
        offerBlasting(exporter, ADAMANTIUM_SCRAP,
                RecipeCategory.MISC, ModItems.ADAMANTIUM_SCRAP, 2.3f, 100, "adamantium_scrap");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ADAMANTIUM_INGOT, RecipeCategory.MISC, ModBlocks.ADAMANTIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VIBRANIUM, RecipeCategory.MISC, ModBlocks.VIBRANIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADAMANTIUM_SCRAP)
                .input('#', ModItems.ADAMANTIUM_SHARD)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(ModItems.ADAMANTIUM_SHARD), conditionsFromItem(ModItems.ADAMANTIUM_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADAMANTIUM_INGOT)
                .input('#', ModItems.ADAMANTIUM_SCRAP)
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(ModItems.ADAMANTIUM_SCRAP), conditionsFromItem(ModItems.ADAMANTIUM_SCRAP))
                .offerTo(exporter, Identifier.of(AncientEchoesMod.MOD_ID, "adamantium_ingot_from_adamantium_scrap"));

                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHERITE_STICK, 2)
                .input('#', Items.NETHERITE_INGOT)
                .pattern("#")
                .pattern("#")
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ADAMANTIUM_SWORD)
                .input('#', ModItems.NETHERITE_STICK)
                .input('X', ModItems.ADAMANTIUM_INGOT)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion(hasItem(ModItems.NETHERITE_STICK), conditionsFromItem(ModItems.NETHERITE_STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_PICKAXE)
                .input('#', ModItems.NETHERITE_STICK)
                .input('X', ModItems.ADAMANTIUM_INGOT)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion(hasItem(ModItems.NETHERITE_STICK), conditionsFromItem(ModItems.NETHERITE_STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAMANTIUM_AXE)
                .input('#', ModItems.NETHERITE_STICK)
                .input('X', ModItems.ADAMANTIUM_INGOT)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion(hasItem(ModItems.NETHERITE_STICK), conditionsFromItem(ModItems.NETHERITE_STICK))
                .offerTo(exporter);

        //ItemTags.PLANKS
//        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.CRAFTING_TABLE)
//                .input('#', ItemTags.PLANKS)
//                .pattern("##")
//                .pattern("##")
//                .criterion("unlock_right_away", TickCriterion.Conditions.createTick())
//                .showNotification(false)
//                .offerTo(exporter);
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.SHIELD)
//                .input('W', ItemTags.PLANKS)
//                .input('o', Items.IRON_INGOT)
//                .pattern("WoW")
//                .pattern("WWW")
//                .pattern(" W ")
//                .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
//                .offerTo(exporter);
//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 4)
//                .input('#', ItemTags.PLANKS)
//                .pattern("#")
//                .pattern("#")
//                .group("sticks")
//                .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
//                .offerTo(exporter);
//        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.WOODEN_AXE)
//                .input('#', Items.STICK)
//                .input('X', ItemTags.PLANKS)
//                .pattern("XX")
//                .pattern("X#")
//                .pattern(" #")
//                .criterion("has_stick", conditionsFromItem(Items.STICK))
//                .offerTo(exporter);
//        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.WOODEN_HOE)
//                .input('#', Items.STICK)
//                .input('X', ItemTags.PLANKS)
//                .pattern("XX")
//                .pattern(" #")
//                .pattern(" #")
//                .criterion("has_stick", conditionsFromItem(Items.STICK))
//                .offerTo(exporter);
//        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.WOODEN_PICKAXE)
//                .input('#', Items.STICK)
//                .input('X', ItemTags.PLANKS)
//                .pattern("XXX")
//                .pattern(" # ")
//                .pattern(" # ")
//                .criterion("has_stick", conditionsFromItem(Items.STICK))
//                .offerTo(exporter);
//        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.WOODEN_SHOVEL)
//                .input('#', Items.STICK)
//                .input('X', ItemTags.PLANKS)
//                .pattern("X")
//                .pattern("#")
//                .pattern("#")
//                .criterion("has_stick", conditionsFromItem(Items.STICK))
//                .offerTo(exporter);
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.WOODEN_SWORD)
//                .input('#', Items.STICK)
//                .input('X', ItemTags.PLANKS)
//                .pattern("X")
//                .pattern("X")
//                .pattern("#")
//                .criterion("has_stick", conditionsFromItem(Items.STICK))
//                .offerTo(exporter);

    }
}
