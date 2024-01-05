package me.dnfneca.lypheamod.world.tree;

import me.dnfneca.lypheamod.LypheaMod;
import me.dnfneca.lypheamod.mixin.TrunkPlacerTypeInvoker;
import me.dnfneca.lypheamod.world.tree.custom.ChestnutTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> CHESTNUT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("chestnut_trunk_placer", ChestnutTrunkPlacer.CODEC);

    public static void register() {
        LypheaMod.LOGGER.info("Registering Trunk Placers for " + LypheaMod.MOD_ID);
    }
}
