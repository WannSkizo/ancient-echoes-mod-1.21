package net.wann.ancientechoesmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.wann.ancientechoesmod.AncientEchoesMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = createTag("needs_netherite_tool");

        public static final TagKey<Block> NEEDS_ADAMANTIUM_TOOL = createTag("needs_adamantium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ADAMANTIUM_TOOL = createTag("incorrect_for_adamantium_tool");

        public static final TagKey<Block> VIBRA_STONE_ORE_REPLACEABLES = createTag("vibra_stone_ore_replaceables");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(AncientEchoesMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(AncientEchoesMod.MOD_ID, name));
        }
    }

}
