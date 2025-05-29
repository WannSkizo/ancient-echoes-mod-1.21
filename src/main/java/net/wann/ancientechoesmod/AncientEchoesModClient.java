package net.wann.ancientechoesmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.wann.ancientechoesmod.block.ModBlocks;
import net.wann.ancientechoesmod.screen.ModScreenHandlers;
import net.wann.ancientechoesmod.screen.custom.QuantumForgeScreen;

public class AncientEchoesModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FAEVIL_SAPLING, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.QUANTUM_FORGE_SCREEN_HANDLER, QuantumForgeScreen::new);
    }
}
