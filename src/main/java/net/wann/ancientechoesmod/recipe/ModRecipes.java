package net.wann.ancientechoesmod.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wann.ancientechoesmod.AncientEchoesMod;

public class ModRecipes {
    public static final RecipeSerializer<QuantumForgeRecipe> QUANTUM_FORGE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(AncientEchoesMod.MOD_ID, "quantum_forge"),
                    new QuantumForgeRecipe.Serializer());
    public static final RecipeType<QuantumForgeRecipe> QUANTUM_FORGE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(AncientEchoesMod.MOD_ID, "quantum_forge"), new RecipeType<QuantumForgeRecipe>() {
                @Override
                public String toString() {
                    return "quantum_forge";
                }
            });

    public static void registerRecipes() {
        AncientEchoesMod.LOGGER.info("Registering Custom Recipes for " + AncientEchoesMod.MOD_ID);
    }
}
