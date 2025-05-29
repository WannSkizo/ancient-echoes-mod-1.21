package net.wann.ancientechoesmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wann.ancientechoesmod.AncientEchoesMod;

public class ModItems {

    public static final Item RAW_ADAMANTIUM_ORE = registerItems("raw_adamantium_ore", new Item(new Item.Settings())); public static final Item ADAMANTIUM_INGOT = registerItems("adamantium_ingot", new Item(new Item.Settings()));
    public static final Item ADAMANTIUM_SCRAP = registerItems("adamantium_scrap", new Item(new Item.Settings()));
    public static final Item ADAMANTIUM_SHARD = registerItems("adamantium_shard", new Item(new Item.Settings()));
    public static final Item RAW_VIBRANIUM_ORE = registerItems("raw_vibranium_ore", new Item(new Item.Settings()));
    public static final Item VIBRANIUM = registerItems("vibranium", new Item(new Item.Settings()));

    public static final Item NETHERITE_STICK = registerItems("netherite_stick", new Item(new Item.Settings()));

    public static final Item ADAMANTIUM_SWORD = registerItems("adamantium_sword",
            new SwordItem(ModToolMaterials.ADAMANTIUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM, 3, -2.4F))));
    public static final Item ADAMANTIUM_PICKAXE = registerItems("adamantium_pickaxe",
            new PickaxeItem(ModToolMaterials.ADAMANTIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM, 1.0F, -2.8F))));
    public static final Item ADAMANTIUM_AXE = registerItems("adamantium_axe",
            new AxeItem(ModToolMaterials.ADAMANTIUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM, 5.0F, -3.0F))));

    private static Item registerItems(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(AncientEchoesMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        AncientEchoesMod.LOGGER.info("Registering Mod Items for " +AncientEchoesMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(RAW_ADAMANTIUM_ORE);
            entries.add(ADAMANTIUM_INGOT);
            entries.add(ADAMANTIUM_SCRAP);
            entries.add(ADAMANTIUM_SHARD);
            entries.add(VIBRANIUM);
            entries.add(RAW_VIBRANIUM_ORE);
            entries.add(NETHERITE_STICK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries ->{
            entries.add(ADAMANTIUM_PICKAXE);
            entries.add(ADAMANTIUM_AXE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->{
            entries.add(ADAMANTIUM_SWORD);
            entries.add(ADAMANTIUM_AXE);
        });
    }
}
