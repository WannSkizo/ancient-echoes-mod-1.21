package net.wann.ancientechoesmod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record QuantumForgeRecipe(Ingredient inputItem, ItemStack output) implements Recipe<QuantumForgeRecipeInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(QuantumForgeRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test((input.getStackInSlot(0)));
    }

    @Override
    public ItemStack craft(QuantumForgeRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.QUANTUM_FORGE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.QUANTUM_FORGE_TYPE;
    }

    public static class Serializer implements RecipeSerializer<QuantumForgeRecipe> {
        public static final MapCodec<QuantumForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(QuantumForgeRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(QuantumForgeRecipe::output))
                .apply(inst, QuantumForgeRecipe::new));

        public static final PacketCodec<RegistryByteBuf, QuantumForgeRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, QuantumForgeRecipe::inputItem,
                        ItemStack.PACKET_CODEC, QuantumForgeRecipe::output,
                        QuantumForgeRecipe::new);

        @Override
        public MapCodec<QuantumForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, QuantumForgeRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
