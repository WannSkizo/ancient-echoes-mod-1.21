package net.wann.ancientechoesmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.wann.ancientechoesmod.block.ModBlocks;
import net.wann.ancientechoesmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ADAMANTIUM_BLOCK);
        addDrop(ModBlocks.PRIMORDIAL_STEEL);

        addDrop(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE, ModItems.RAW_ADAMANTIUM_ORE));
        addDrop(ModBlocks.VIBRANIUM_ORE, oreDrops(ModBlocks.VIBRANIUM_ORE, ModItems.RAW_VIBRANIUM_ORE));

        addDrop(ModBlocks.FAEVIL_LOG);
        addDrop(ModBlocks.FAEVIL_WOOD);
        addDrop(ModBlocks.STRIPPED_FAEVIL_LOG);
        addDrop(ModBlocks.STRIPPED_FAEVIL_WOOD);
        addDrop(ModBlocks.FAEVIL_PLANKS);
        addDrop(ModBlocks.FAEVIL_SAPLING);

        addDrop(ModBlocks.FAEVIL_LEAVES, leavesDrops(ModBlocks.FAEVIL_LEAVES, ModBlocks.FAEVIL_SAPLING, 0.0625F));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
