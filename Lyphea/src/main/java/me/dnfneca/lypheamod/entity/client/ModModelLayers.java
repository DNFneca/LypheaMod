package me.dnfneca.lypheamod.entity.client;

import me.dnfneca.lypheamod.LypheaMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(LypheaMod.MOD_ID, "porcupine"), "main");
}
