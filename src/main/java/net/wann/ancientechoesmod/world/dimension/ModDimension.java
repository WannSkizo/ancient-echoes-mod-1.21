package net.wann.ancientechoesmod.world.dimension;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.wann.ancientechoesmod.AncientEchoesMod;

import java.util.OptionalLong;

public class ModDimension {
    public static final RegistryKey<DimensionOptions> VIBRALUNE = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(AncientEchoesMod.MOD_ID, "vibralune.json"));
    public static final RegistryKey<World> VIBRALUNE_LEVEL = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(AncientEchoesMod.MOD_ID, "vibralune.json"));
    public static final RegistryKey<DimensionType> VIBRALUNE_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(AncientEchoesMod.MOD_ID, "vibralune_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(ModDimension.VIBRALUNE_TYPE,
                new DimensionType(
                        OptionalLong.empty(),
                        true,
                        false,
                        false,
                        true,
                        1.0,
                        false,
                        false,
                        0,
                        384,
                        384,
                        BlockTags.INFINIBURN_OVERWORLD,
                        DimensionTypes.OVERWORLD_ID,
                        0.0F,
                        new DimensionType.MonsterSettings(false, true, UniformIntProvider.create(0, 7), 0)
                )
        );
    }
}
