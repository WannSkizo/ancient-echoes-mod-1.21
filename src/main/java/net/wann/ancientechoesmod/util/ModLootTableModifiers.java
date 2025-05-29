package net.wann.ancientechoesmod.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.wann.ancientechoesmod.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier DESERT_PYRAMID_ID =
            Identifier.of("minecraft", "chests/desert_pyramid");

    public static void modifyLootTable() {
        LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin() &&
            DESERT_PYRAMID_ID.equals(registryKey.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(ModItems.ADAMANTIUM_SHARD))
                        .conditionally(RandomChanceLootCondition.builder(1.0F))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0F)));
                builder.pool(poolBuilder);
            }
        }));
    }
}
