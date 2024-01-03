package me.dnfneca.lypheamod.entity.client;

import me.dnfneca.lypheamod.entity.custom.DragonEntity;
import me.dnfneca.lypheamod.entity.custom.PorcupineEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static me.dnfneca.lypheamod.client.LypheaModClient.MOD_ID;

public class DragonRenderer extends MobEntityRenderer<DragonEntity, DragonModel<DragonEntity>> {
    public static Identifier TEXTURE = new Identifier(MOD_ID, "textures/entity/dragontexture.png");

    public DragonRenderer(EntityRendererFactory.Context context) {
        super(context, new DragonModel<>(context.getPart(ModModelLayers.DRAGON)), 0.6f);
    }

    @Override
    public Identifier getTexture(DragonEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(DragonEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(2f, 2f, 2f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
