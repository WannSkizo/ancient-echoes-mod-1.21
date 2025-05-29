package net.wann.ancientechoesmod.world.biome;
//
//import terrablender.api.Regions;
//import terrablender.api.SurfaceRuleManager;
//import terrablender.api.TerraBlenderApi;
//import net.minecraft.util.Identifier;
//import net.wann.ancientechoesmod.AncientEchoesMod;
//import net.wann.ancientechoesmod.world.biome.surface.ModMaterialRules;
//
//public class ModTerrablenderAPI implements TerraBlenderApi {
//    @Override
//    public void onTerraBlenderInitialized() {
//        Regions.register(new ModOverworldRegion(Identifier.of(OresMod.MOD_ID, "overworld"), 4));
//
//        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, OresMod.MOD_ID, ModMaterialRules.makeRules());
//    }
//}
