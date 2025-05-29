package net.wann.ancientechoesmod.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.wann.ancientechoesmod.AncientEchoesMod;
import net.wann.ancientechoesmod.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator FAEVILWOOD = new SaplingGenerator(AncientEchoesMod.MOD_ID + ":faevilwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.FAEVILWOOD), Optional.empty());
}
