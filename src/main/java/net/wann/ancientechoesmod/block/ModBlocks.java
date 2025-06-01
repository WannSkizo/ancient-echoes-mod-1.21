package net.wann.ancientechoesmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.wann.ancientechoesmod.AncientEchoesMod;
import net.wann.ancientechoesmod.block.custom.QuantumForgeBlock;
import net.wann.ancientechoesmod.world.tree.ModSaplingGenerators;

public class ModBlocks {

    public static final Block DEEPSLATE_ADAMANTIUM_ORE = registerBlock("deepslate_adamantium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create().strength(4.4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block VIBRANIUM_ORE = registerBlock("vibranium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(4.4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block COAL_ORE = registerBlock("coal_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(0, 2),
                    AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block IRON_ORE = registerBlock("iron_ore",
            new ExperienceDroppingBlock(ConstantIntProvider.create(0),
                    AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block REDSTONE_ORE = registerBlock("redstone_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(3.0f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block VIBRA_STONE = registerBlock("vibra_stone",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block ADAMANTIUM_BLOCK = registerBlock("adamantium_block",
            new Block(AbstractBlock.Settings.create().strength(53.0F, 1200.0F)
            .requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block VIBRANIUM_BLOCK = registerBlock("vibranium_block",
            new Block(AbstractBlock.Settings.create().strength(50.0F, 1200.0F)
            .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block PRIMORDIAL_STEEL = registerBlock("primordial_steel",
            new Block(AbstractBlock.Settings.create().strength(50.0F, 1200.0F)
            .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block VIBRA_PORTAL = registerBlock("vibra_portal",
            new Block(AbstractBlock.Settings.create().strength(50.0F, 1200.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block QUANTUM_FORGE = registerBlock("quantum_forge",
            new QuantumForgeBlock(AbstractBlock.Settings.create()));

    public static final Block FAEVIL_LOG = registerBlock("faevil_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block FAEVIL_WOOD = registerBlock("faevil_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_FAEVIL_LOG = registerBlock("stripped_faevil_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_FAEVIL_WOOD = registerBlock("stripped_faevil_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block FAEVIL_PLANKS = registerBlock("faevil_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block FAEVIL_LEAVES = registerBlock("faevil_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block FAEVIL_SAPLING = registerBlock("faevil_sapling",
            new SaplingBlock(ModSaplingGenerators.FAEVILWOOD, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AncientEchoesMod.MOD_ID, name), block);
    }

    //Helper function
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(AncientEchoesMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        AncientEchoesMod.LOGGER.info("Registering Mod Blocks for " +AncientEchoesMod.MOD_ID);

        //Adds block to creative menu
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ADAMANTIUM_BLOCK);
            entries.add(VIBRANIUM_BLOCK);
            entries.add(VIBRA_PORTAL);
            entries.add(FAEVIL_LOG);
            entries.add(FAEVIL_WOOD);
            entries.add(STRIPPED_FAEVIL_LOG);
            entries.add(STRIPPED_FAEVIL_WOOD);
            entries.add(FAEVIL_PLANKS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(QUANTUM_FORGE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(DEEPSLATE_ADAMANTIUM_ORE);
            entries.add(VIBRA_STONE);
            entries.add(VIBRANIUM_ORE);
            entries.add(COAL_ORE);
            entries.add(IRON_ORE);
            entries.add(REDSTONE_ORE);
            entries.add(PRIMORDIAL_STEEL);
            entries.add(FAEVIL_LEAVES);
            entries.add(FAEVIL_SAPLING);
        });
    }
}
