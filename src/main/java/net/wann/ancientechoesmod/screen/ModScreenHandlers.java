package net.wann.ancientechoesmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Identifier;
import net.wann.ancientechoesmod.AncientEchoesMod;
import net.wann.ancientechoesmod.screen.custom.QuantumForgeScreenHandler;

public class ModScreenHandlers {
    public static final ScreenHandlerType<QuantumForgeScreenHandler> QUANTUM_FORGE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(AncientEchoesMod.MOD_ID, "quantum_forge_screen_handler"),
                    new ExtendedScreenHandlerType<>(QuantumForgeScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void registerScreenHandlers() {
        AncientEchoesMod.LOGGER.info("Registering Screen Handlers for " + AncientEchoesMod.MOD_ID);
    }
}

