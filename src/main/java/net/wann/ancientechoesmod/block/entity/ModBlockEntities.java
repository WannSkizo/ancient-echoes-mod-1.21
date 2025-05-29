package net.wann.ancientechoesmod.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wann.ancientechoesmod.AncientEchoesMod;
import net.wann.ancientechoesmod.block.ModBlocks;
import net.wann.ancientechoesmod.block.entity.custom.QuantumForgeBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<QuantumForgeBlockEntity>  QUANTUM_FORGE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(AncientEchoesMod.MOD_ID, "quantum_forge_be"),
                    BlockEntityType.Builder.create(QuantumForgeBlockEntity::new, ModBlocks.QUANTUM_FORGE).build(null));

    public static void registerBlockEntitie() {
        AncientEchoesMod.LOGGER.info("RegisteringRegistering Block Entities for " + AncientEchoesMod.MOD_ID);
    }
}
