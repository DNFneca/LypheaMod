package me.dnfneca.lypheamod.entity.client;

import me.dnfneca.lypheamod.entity.custom.ArmadiloEntity;
import me.dnfneca.lypheamod.entity.custom.PorcupineEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static me.dnfneca.lypheamod.client.LypheaModClient.MOD_ID;

public class ArmadiloRenderer extends MobEntityRenderer<ArmadiloEntity, ArmadiloModel<ArmadiloEntity>> {
    public static Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/armadilo.png");

    public ArmadiloRenderer(EntityRendererFactory.Context context) {
        super(context, new ArmadiloModel<>(context.getPart(ModModelLayers.ARMADILO)), 0.6f);
    }

    @Override
    public Identifier getTexture(ArmadiloEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ArmadiloEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
