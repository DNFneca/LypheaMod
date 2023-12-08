package me.dnfneca.lypheamod.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import static me.dnfneca.lypheamod.client.LypheaModClient.MOD_ID;

public class ModModelLayers {
    public static EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(MOD_ID, "porcupine"), "main");
    public static EntityModelLayer ARMADILO =
            new EntityModelLayer(new Identifier(MOD_ID, "armadilo"), "main");
    public static EntityModelLayer DRAGON =
            new EntityModelLayer(new Identifier(MOD_ID, "dragon"), "main");
}
