package me.dnfneca.lypheamod.entity.client;

import me.dnfneca.lypheamod.entity.custom.DragonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class DragonModel <T extends DragonEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Model;
	private final ModelPart Head;
	public DragonModel(ModelPart root) {
		this.Model = root.getChild("Model");
		this.Head = Model.getChild("Head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Model = modelPartData.addChild("Model", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Leftarm = Model.addChild("Leftarm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

		ModelPartData bone13 = Leftarm.addChild("bone13", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData cube_r1 = bone13.addChild("cube_r1", ModelPartBuilder.create().uv(184, 95).cuboid(4.0F, -14.0F, -10.0F, 7.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData bone14 = Leftarm.addChild("bone14", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData cube_r2 = bone14.addChild("cube_r2", ModelPartBuilder.create().uv(25, 73).cuboid(-1.0F, -12.0F, -8.0F, 4.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		ModelPartData bone15 = Leftarm.addChild("bone15", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData cube_r3 = bone15.addChild("cube_r3", ModelPartBuilder.create().uv(79, 62).cuboid(-3.0F, -4.7F, -8.0F, 3.0F, 5.7F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		ModelPartData bone16 = Leftarm.addChild("bone16", ModelPartBuilder.create().uv(122, 25).cuboid(-6.0F, 0.0F, -9.0F, 6.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData bone17 = Leftarm.addChild("bone17", ModelPartBuilder.create().uv(31, 29).cuboid(-10.0F, -2.0F, -5.5F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(129, 107).cuboid(-8.0F, -1.7F, -6.0F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone18 = Leftarm.addChild("bone18", ModelPartBuilder.create().uv(129, 107).cuboid(-8.0F, -1.7F, -9.0F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F))
				.uv(5, 67).cuboid(-10.0F, -2.0F, -8.5F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone19 = Leftarm.addChild("bone19", ModelPartBuilder.create().uv(129, 107).cuboid(-8.0F, -1.7F, -7.5F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F))
				.uv(61, 19).cuboid(-10.0F, -2.0F, -7.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone20 = Leftarm.addChild("bone20", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r4 = bone20.addChild("cube_r4", ModelPartBuilder.create().uv(5, 39).cuboid(-6.5F, -1.7F, 0.0F, 0.0F, 1.7F, 2.0F, new Dilation(0.0F))
				.uv(32, 94).cuboid(-7.0F, -1.7F, -2.0F, 1.0F, 1.7F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.5672F, 0.0F));

		ModelPartData Rightarm = Model.addChild("Rightarm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone5 = Rightarm.addChild("bone5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r5 = bone5.addChild("cube_r5", ModelPartBuilder.create().uv(148, 42).cuboid(4.0F, -14.0F, 6.0F, 7.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData bone6 = Rightarm.addChild("bone6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData cube_r6 = bone6.addChild("cube_r6", ModelPartBuilder.create().uv(61, 72).cuboid(-1.0F, -12.0F, 7.0F, 4.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		ModelPartData bone7 = Rightarm.addChild("bone7", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData cube_r7 = bone7.addChild("cube_r7", ModelPartBuilder.create().uv(87, 49).cuboid(-3.0F, -4.7F, 7.0F, 3.0F, 5.7F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		ModelPartData bone8 = Rightarm.addChild("bone8", ModelPartBuilder.create().uv(171, 19).cuboid(-6.0F, 0.0F, 6.0F, 6.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData bone9 = Rightarm.addChild("bone9", ModelPartBuilder.create().uv(129, 107).cuboid(-8.0F, -1.7F, 6.0F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F))
				.uv(19, 66).cuboid(-10.0F, -2.0F, 6.5F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone10 = Rightarm.addChild("bone10", ModelPartBuilder.create().uv(112, 108).cuboid(-8.0F, -1.7F, 7.5F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F))
				.uv(27, 37).cuboid(-10.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone11 = Rightarm.addChild("bone11", ModelPartBuilder.create().uv(125, 120).cuboid(-8.0F, -1.7F, 9.0F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F))
				.uv(74, 20).cuboid(-10.0F, -2.0F, 9.5F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone12 = Rightarm.addChild("bone12", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r8 = bone12.addChild("cube_r8", ModelPartBuilder.create().uv(34, 99).mirrored().cuboid(-7.0F, -1.7F, 1.0F, 1.0F, 1.7F, 2.0F, new Dilation(0.0F)).mirrored(false)
				.uv(89, 17).mirrored().cuboid(-6.5F, -1.7F, -1.0F, 0.0F, 1.7F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.5672F, 0.0F));

		ModelPartData Head = Model.addChild("Head", ModelPartBuilder.create().uv(245, 213).cuboid(-38.0F, -20.0F, -4.0F, 6.0F, 8.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone47 = Head.addChild("bone47", ModelPartBuilder.create().uv(154, 4).cuboid(-45.8F, -14.0F, -2.5F, 7.8F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r9 = bone47.addChild("cube_r9", ModelPartBuilder.create().uv(130, 96).mirrored().cuboid(-45.2F, -15.0F, -12.0F, 8.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
				.uv(130, 96).mirrored().cuboid(-44.2F, -15.0F, -12.1F, 8.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
				.uv(155, 97).mirrored().cuboid(-44.2F, -14.0F, -12.1F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.0F));

		ModelPartData cube_r10 = bone47.addChild("cube_r10", ModelPartBuilder.create().uv(107, 99).cuboid(-45.4F, -15.0F, 11.0F, 8.0F, 1.0F, 0.0F, new Dilation(0.0F))
				.uv(107, 99).cuboid(-44.4F, -15.0F, 11.1F, 8.0F, 1.0F, 0.0F, new Dilation(0.0F))
				.uv(147, 16).cuboid(-44.4F, -14.0F, 9.1F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.0F));

		ModelPartData bone48 = Head.addChild("bone48", ModelPartBuilder.create().uv(46, 31).cuboid(-45.8F, -17.0F, -2.5F, 7.8F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(5, 29).cuboid(-45.8F, -15.0F, -2.5F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(5, 29).cuboid(-45.7F, -15.0F, -3.5F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(28, 211).cuboid(-43.0F, -14.1F, -1.0F, 5.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r11 = bone48.addChild("cube_r11", ModelPartBuilder.create().uv(185, 10).cuboid(-44.4F, -14.0F, 9.1F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, -0.2182F, 0.0F));

		ModelPartData cube_r12 = bone48.addChild("cube_r12", ModelPartBuilder.create().uv(80, 75).cuboid(-40.8F, -26.1F, -2.4F, 8.8F, 2.8F, 3.8F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		ModelPartData cube_r13 = bone48.addChild("cube_r13", ModelPartBuilder.create().uv(182, 30).mirrored().cuboid(-44.2F, -14.0F, -12.1F, 8.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.2182F, 0.0F));

		ModelPartData bone49 = Head.addChild("bone49", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r14 = bone49.addChild("cube_r14", ModelPartBuilder.create().uv(0, 93).mirrored().cuboid(-31.9F, -21.0F, 19.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, -0.6981F, 0.0F));

		ModelPartData cube_r15 = bone49.addChild("cube_r15", ModelPartBuilder.create().uv(0, 98).cuboid(-31.1F, -21.0F, -23.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0873F, 0.6981F, 0.0F));

		ModelPartData bone50 = Head.addChild("bone50", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r16 = bone50.addChild("cube_r16", ModelPartBuilder.create().uv(12, 107).cuboid(-43.5F, -26.0F, -1.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F))
				.uv(24, 109).cuboid(-40.0F, -23.0F, -1.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		ModelPartData cube_r17 = bone50.addChild("cube_r17", ModelPartBuilder.create().uv(5, 112).cuboid(-39.0F, -31.0F, -1.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		ModelPartData cube_r18 = bone50.addChild("cube_r18", ModelPartBuilder.create().uv(159, 107).cuboid(-34.0F, -20.0F, -13.1F, 10.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));

		ModelPartData cube_r19 = bone50.addChild("cube_r19", ModelPartBuilder.create().uv(159, 107).mirrored().cuboid(-8.1938F, -4.0F, 0.7364F, 10.0F, 9.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-34.0F, -16.0F, 4.0F, -3.1416F, 0.2635F, 3.1416F));

		ModelPartData cube_r20 = bone50.addChild("cube_r20", ModelPartBuilder.create().uv(3, 176).mirrored().cuboid(-6.8922F, -7.0F, 0.388F, 13.0F, 14.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-28.0F, -18.0F, 5.0F, -3.1416F, 0.2618F, 3.1416F));

		ModelPartData cube_r21 = bone50.addChild("cube_r21", ModelPartBuilder.create().uv(3, 176).cuboid(-34.0F, -25.0F, -10.0F, 13.0F, 14.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		ModelPartData Rightwing = Model.addChild("Rightwing", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData bone57 = Rightwing.addChild("bone57", ModelPartBuilder.create().uv(73, 170).mirrored().cuboid(4.0F, -21.0F, -7.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r22 = bone57.addChild("cube_r22", ModelPartBuilder.create().uv(32, 215).mirrored().cuboid(8.0F, -20.0F, -22.0F, 3.0F, 2.0F, 19.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		ModelPartData bone58 = Rightwing.addChild("bone58", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r23 = bone58.addChild("cube_r23", ModelPartBuilder.create().uv(186, 228).mirrored().cuboid(32.0F, -19.0F, 19.0F, 7.0F, 0.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5272F, 0.0F));

		ModelPartData cube_r24 = bone58.addChild("cube_r24", ModelPartBuilder.create().uv(118, 160).mirrored().cuboid(8.0F, -20.0F, -25.0F, 26.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		ModelPartData bone59 = Rightwing.addChild("bone59", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r25 = bone59.addChild("cube_r25", ModelPartBuilder.create().uv(8, 191).mirrored().cuboid(51.0F, -20.0F, -136.0F, 2.0F, 2.0F, 43.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.48F, 0.0F));

		ModelPartData cube_r26 = bone59.addChild("cube_r26", ModelPartBuilder.create().uv(8, 191).mirrored().cuboid(34.0F, -20.0F, -101.0F, 2.0F, 2.0F, 43.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.3054F, 0.0F));

		ModelPartData cube_r27 = bone59.addChild("cube_r27", ModelPartBuilder.create().uv(19, 202).mirrored().cuboid(26.0F, -20.0F, -62.0F, 2.0F, 2.0F, 32.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		ModelPartData bone60 = Rightwing.addChild("bone60", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r28 = bone60.addChild("cube_r28", ModelPartBuilder.create().uv(15, 198).mirrored().cuboid(43.0F, -20.0F, -67.0F, 2.0F, 2.0F, 36.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.3526F, 0.0F));

		ModelPartData cube_r29 = bone60.addChild("cube_r29", ModelPartBuilder.create().uv(5, 188).mirrored().cuboid(37.0F, -20.0F, -39.0F, 2.0F, 2.0F, 46.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.1781F, 0.0F));

		ModelPartData bone61 = Rightwing.addChild("bone61", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r30 = bone61.addChild("cube_r30", ModelPartBuilder.create().uv(7, 190).mirrored().cuboid(48.0F, -20.0F, -79.0F, 2.0F, 2.0F, 44.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-15.0F, 0.0F, -18.0F, 0.0F, 0.8727F, 0.0F));

		ModelPartData cube_r31 = bone61.addChild("cube_r31", ModelPartBuilder.create().uv(0, 179).mirrored().cuboid(37.0F, -20.0F, -47.0F, 2.0F, 2.0F, 55.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-15.0F, 0.0F, -18.0F, 0.0F, 0.6109F, 0.0F));

		ModelPartData bone62 = Rightwing.addChild("bone62", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r32 = bone62.addChild("cube_r32", ModelPartBuilder.create().uv(38, 221).mirrored().cuboid(29.0F, -20.0F, -41.0F, 2.0F, 2.0F, 13.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r33 = bone62.addChild("cube_r33", ModelPartBuilder.create().uv(21, 204).mirrored().cuboid(25.0F, -20.0F, -32.0F, 2.0F, 2.0F, 30.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.4399F, 0.0F));

		ModelPartData bone64 = Rightwing.addChild("bone64", ModelPartBuilder.create().uv(391, 66).cuboid(-41.0F, -19.0F, -30.0F, 47.0F, 0.0F, 27.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone65 = Rightwing.addChild("bone65", ModelPartBuilder.create().uv(336, 136).cuboid(-55.0F, -19.1F, -57.0F, 73.0F, 0.0F, 30.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone66 = Rightwing.addChild("bone66", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r34 = bone66.addChild("cube_r34", ModelPartBuilder.create().uv(453, 0).cuboid(-12.0F, -18.9F, -37.0F, 16.0F, 0.0F, 27.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.48F, 0.0F));

		ModelPartData bone67 = Rightwing.addChild("bone67", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r35 = bone67.addChild("cube_r35", ModelPartBuilder.create().uv(225, 0).cuboid(-88.0F, -18.9F, -73.0F, 90.0F, 0.0F, 47.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.48F, 0.0F));

		ModelPartData bone68 = Rightwing.addChild("bone68", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r36 = bone68.addChild("cube_r36", ModelPartBuilder.create().uv(248, 166).cuboid(-99.0F, -19.0F, -110.0F, 97.0F, 0.0F, 70.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		ModelPartData Neck = Model.addChild("Neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone21 = Neck.addChild("bone21", ModelPartBuilder.create().uv(176, 41).cuboid(-10.0F, -19.0F, -3.0F, 2.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone22 = Neck.addChild("bone22", ModelPartBuilder.create().uv(148, 61).cuboid(-12.0F, -19.0F, -3.0F, 2.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone23 = Neck.addChild("bone23", ModelPartBuilder.create().uv(181, 63).cuboid(-14.0F, -19.0F, -3.0F, 2.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone24 = Neck.addChild("bone24", ModelPartBuilder.create().uv(38, 57).cuboid(-16.0F, -19.0F, -3.0F, 2.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone25 = Neck.addChild("bone25", ModelPartBuilder.create().uv(95, 56).cuboid(-18.0F, -19.0F, -3.0F, 2.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone26 = Neck.addChild("bone26", ModelPartBuilder.create().uv(119, 53).cuboid(-20.0F, -19.0F, -3.0F, 2.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone27 = Neck.addChild("bone27", ModelPartBuilder.create().uv(12, 41).cuboid(-22.0F, -19.0F, -2.0F, 2.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone28 = Neck.addChild("bone28", ModelPartBuilder.create().uv(34, 41).cuboid(-24.0F, -19.0F, -2.0F, 2.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone29 = Neck.addChild("bone29", ModelPartBuilder.create().uv(69, 42).cuboid(-26.0F, -19.0F, -2.0F, 2.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone30 = Neck.addChild("bone30", ModelPartBuilder.create().uv(50, 45).cuboid(-28.0F, -19.0F, -2.0F, 2.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone31 = Neck.addChild("bone31", ModelPartBuilder.create().uv(23, 52).cuboid(-30.0F, -19.0F, -2.0F, 2.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone32 = Neck.addChild("bone32", ModelPartBuilder.create().uv(1, 53).cuboid(-32.0F, -19.0F, -2.0F, 2.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Leftarm2 = Model.addChild("Leftarm2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone40 = Leftarm2.addChild("bone40", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r37 = bone40.addChild("cube_r37", ModelPartBuilder.create().uv(11, 91).cuboid(7.0F, -21.0F, 3.5F, 7.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.2182F));

		ModelPartData bone41 = Leftarm2.addChild("bone41", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r38 = bone41.addChild("cube_r38", ModelPartBuilder.create().uv(62, 58).cuboid(15.0F, 3.0F, 4.0F, 4.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -10.0F, 0.0F, 0.0F, -0.9163F));

		ModelPartData bone42 = Leftarm2.addChild("bone42", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r39 = bone42.addChild("cube_r39", ModelPartBuilder.create().uv(85, 34).cuboid(10.2F, -15.0F, 4.0F, 2.5F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.6109F));

		ModelPartData bone43 = Leftarm2.addChild("bone43", ModelPartBuilder.create().uv(150, 27).cuboid(11.0F, -2.0F, -7.0F, 6.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone44 = Leftarm2.addChild("bone44", ModelPartBuilder.create().uv(3, 123).cuboid(7.0F, -2.0F, 3.5F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(18, 32).cuboid(9.0F, -1.7F, 3.0F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -10.0F));

		ModelPartData bone45 = Leftarm2.addChild("bone45", ModelPartBuilder.create().uv(33, 115).cuboid(7.0F, -2.0F, -3.5F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(4, 15).cuboid(9.0F, -1.7F, -4.0F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone46 = Leftarm2.addChild("bone46", ModelPartBuilder.create().uv(28, 122).cuboid(7.0F, -2.0F, -5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(9.0F, -1.7F, -5.5F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Rightarm2 = Model.addChild("Rightarm2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone33 = Rightarm2.addChild("bone33", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r40 = bone33.addChild("cube_r40", ModelPartBuilder.create().uv(114, 71).cuboid(7.0F, -21.0F, 4.0F, 7.0F, 9.0F, 2.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		ModelPartData bone34 = Rightarm2.addChild("bone34", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r41 = bone34.addChild("cube_r41", ModelPartBuilder.create().uv(42, 72).cuboid(15.0F, 3.0F, 4.0F, 4.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9163F));

		ModelPartData bone35 = Rightarm2.addChild("bone35", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r42 = bone35.addChild("cube_r42", ModelPartBuilder.create().uv(99, 39).cuboid(10.2F, -15.0F, 4.0F, 2.5F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		ModelPartData bone36 = Rightarm2.addChild("bone36", ModelPartBuilder.create().uv(115, 40).cuboid(11.0F, -2.0F, 3.0F, 6.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone37 = Rightarm2.addChild("bone37", ModelPartBuilder.create().uv(110, 131).cuboid(9.0F, -1.7F, 6.0F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F))
				.uv(113, 20).cuboid(7.0F, -2.0F, 6.5F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone38 = Rightarm2.addChild("bone38", ModelPartBuilder.create().uv(131, 133).cuboid(9.0F, -1.7F, 4.5F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F))
				.uv(18, 19).cuboid(7.0F, -2.0F, 5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone39 = Rightarm2.addChild("bone39", ModelPartBuilder.create().uv(45, 20).cuboid(7.0F, -2.0F, 3.5F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(101, 29).cuboid(9.0F, -1.7F, 3.0F, 2.0F, 1.7F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData tail = Model.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bone = tail.addChild("bone", ModelPartBuilder.create().uv(180, 175).cuboid(22.0F, -18.0F, -3.0F, 17.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r43 = bone.addChild("cube_r43", ModelPartBuilder.create().uv(119, 191).cuboid(20.0F, -9.5F, -9.5F, 19.0F, 3.5F, 3.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData bone2 = tail.addChild("bone2", ModelPartBuilder.create().uv(49, 98).cuboid(39.0F, -16.0F, -2.0F, 14.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData bone3 = tail.addChild("bone3", ModelPartBuilder.create().uv(50, 112).cuboid(53.0F, -16.0F, -1.0F, 15.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData bone4 = tail.addChild("bone4", ModelPartBuilder.create().uv(59, 130).cuboid(68.0F, -18.0F, -0.7F, 13.0F, 2.0F, 1.4F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Body = Model.addChild("Body", ModelPartBuilder.create().uv(0, 196).cuboid(-8.0F, -20.0F, -6.0F, 13.0F, 13.0F, 12.0F, new Dilation(0.0F))
				.uv(119, 221).cuboid(5.0F, -19.1F, -4.0F, 17.0F, 7.1F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r44 = Body.addChild("cube_r44", ModelPartBuilder.create().uv(166, 211).cuboid(4.0F, -10.2F, -10.0F, 18.0F, 5.7F, 5.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData Leftwing = Model.addChild("Leftwing", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData bone53 = Leftwing.addChild("bone53", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r45 = bone53.addChild("cube_r45", ModelPartBuilder.create().uv(38, 221).cuboid(-31.0F, -20.0F, -41.0F, 2.0F, 2.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r46 = bone53.addChild("cube_r46", ModelPartBuilder.create().uv(21, 204).cuboid(-27.0F, -20.0F, -32.0F, 2.0F, 2.0F, 30.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 1.4399F, -3.1416F));

		ModelPartData bone54 = Leftwing.addChild("bone54", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r47 = bone54.addChild("cube_r47", ModelPartBuilder.create().uv(391, 66).mirrored().cuboid(-6.0F, -19.0F, -30.0F, 47.0F, 0.0F, 27.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData bone55 = Leftwing.addChild("bone55", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r48 = bone55.addChild("cube_r48", ModelPartBuilder.create().uv(336, 136).mirrored().cuboid(-18.0F, -19.1F, -57.0F, 73.0F, 0.0F, 30.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData bone52 = Leftwing.addChild("bone52", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r49 = bone52.addChild("cube_r49", ModelPartBuilder.create().uv(225, 0).mirrored().cuboid(-2.0F, -18.9F, -73.0F, 90.0F, 0.0F, 47.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 3.1416F, -0.48F, 3.1416F));

		ModelPartData bone56 = Leftwing.addChild("bone56", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r50 = bone56.addChild("cube_r50", ModelPartBuilder.create().uv(248, 166).mirrored().cuboid(2.0F, -19.0F, -110.0F, 97.0F, 0.0F, 70.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, -0.6109F, -3.1416F));

		ModelPartData bone51 = Leftwing.addChild("bone51", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r51 = bone51.addChild("cube_r51", ModelPartBuilder.create().uv(453, 0).mirrored().cuboid(-4.0F, -18.9F, -37.0F, 16.0F, 0.0F, 27.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -2.6616F, 0.0F));

		ModelPartData bone63 = Leftwing.addChild("bone63", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r52 = bone63.addChild("cube_r52", ModelPartBuilder.create().uv(7, 190).cuboid(-50.0F, -20.0F, -79.0F, 2.0F, 2.0F, 44.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, 0.0F, 17.0F, -3.1416F, 0.8727F, -3.1416F));

		ModelPartData cube_r53 = bone63.addChild("cube_r53", ModelPartBuilder.create().uv(0, 179).cuboid(-39.0F, -20.0F, -47.0F, 2.0F, 2.0F, 55.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, 0.0F, 17.0F, -3.1416F, 0.6109F, 3.1416F));

		ModelPartData bone69 = Leftwing.addChild("bone69", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r54 = bone69.addChild("cube_r54", ModelPartBuilder.create().uv(15, 198).cuboid(-45.0F, -20.0F, -67.0F, 2.0F, 2.0F, 36.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 3.1416F, 1.3526F, 3.1416F));

		ModelPartData cube_r55 = bone69.addChild("cube_r55", ModelPartBuilder.create().uv(5, 188).cuboid(-39.0F, -20.0F, -39.0F, 2.0F, 2.0F, 46.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 1.1781F, 3.1416F));

		ModelPartData bone70 = Leftwing.addChild("bone70", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r56 = bone70.addChild("cube_r56", ModelPartBuilder.create().uv(8, 191).cuboid(-53.0F, -20.0F, -136.0F, 2.0F, 2.0F, 43.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.48F, -3.1416F));

		ModelPartData cube_r57 = bone70.addChild("cube_r57", ModelPartBuilder.create().uv(8, 191).cuboid(-36.0F, -20.0F, -101.0F, 2.0F, 2.0F, 43.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.3054F, -3.1416F));

		ModelPartData cube_r58 = bone70.addChild("cube_r58", ModelPartBuilder.create().uv(19, 202).cuboid(-28.0F, -20.0F, -62.0F, 2.0F, 2.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.1745F, -3.1416F));

		ModelPartData bone71 = Leftwing.addChild("bone71", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r59 = bone71.addChild("cube_r59", ModelPartBuilder.create().uv(186, 228).cuboid(-39.0F, -19.0F, 19.0F, 7.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 3.1416F, 1.5272F, 3.1416F));

		ModelPartData cube_r60 = bone71.addChild("cube_r60", ModelPartBuilder.create().uv(118, 160).cuboid(-34.0F, -20.0F, -25.0F, 26.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.3491F, 3.1416F));

		ModelPartData bone72 = Leftwing.addChild("bone72", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r61 = bone72.addChild("cube_r61", ModelPartBuilder.create().uv(32, 215).cuboid(-11.0F, -20.0F, -22.0F, 3.0F, 2.0F, 19.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.3491F, 3.1416F));

		ModelPartData cube_r62 = bone72.addChild("cube_r62", ModelPartBuilder.create().uv(73, 170).cuboid(-10.0F, -21.0F, -7.0F, 6.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));
		return TexturedModelData.of(modelData, 512, 236);
	}
	@Override
	public void setAngles(DragonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Model.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return Model;
	}
}