package me.dnfneca.lypheamod.world.tree;

import me.dnfneca.lypheamod.LypheaMod;
import me.dnfneca.lypheamod.mixin.FoliagePlacerTypeInvoker;
import me.dnfneca.lypheamod.world.tree.custom.ChestnutFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> CHESTNUT_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("chestnut_foliage_placer", ChestnutFoliagePlacer.CODEC);

    public static void register() {
        LypheaMod.LOGGER.info("Registering Foliage Placer for " + LypheaMod.MOD_ID);
    }
}
