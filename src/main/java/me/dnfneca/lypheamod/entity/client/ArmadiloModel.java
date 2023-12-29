package me.dnfneca.lypheamod.entity.client;

import me.dnfneca.lypheamod.entity.animation.ArmadiloAnimation;
import me.dnfneca.lypheamod.entity.animation.ModAnimations;
import me.dnfneca.lypheamod.entity.custom.ArmadiloEntity;
import me.dnfneca.lypheamod.entity.custom.PorcupineEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ArmadiloModel<T extends ArmadiloEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bs_vm_armadillo;



//	private final ModelPart right_back;
//	private final ModelPart left_back;
//	private final ModelPart tail;
//	private final ModelPart cube_r1;
//	private final ModelPart torso;
//	private final ModelPart right_front;
//	private final ModelPart left_front;
	private final ModelPart head;
//	private final ModelPart cube_r2;
//	private final ModelPart cube_r3;
//	private final ModelPart cube_r4;
//	private final ModelPart cube_r5;
//	private final ModelPart hitbox;
	public ArmadiloModel(ModelPart root) {
		this.bs_vm_armadillo = root.getChild("bs_vm_armadillo");
		this.head = this.bs_vm_armadillo.getChild("torso").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bs_vm_armadillo = modelPartData.addChild("bs_vm_armadillo", ModelPartBuilder.create().uv(26, 24).cuboid(-6.5F, -13.6766F, -10.14F, 13.0F, 12.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 22.6766F, 9.64F));

		ModelPartData right_back = bs_vm_armadillo.addChild("right_back", ModelPartBuilder.create().uv(24, 44).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, -1.6766F, -4.14F));

		ModelPartData left_back = bs_vm_armadillo.addChild("left_back", ModelPartBuilder.create().uv(19, 44).mirrored().cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(3.5F, -1.6766F, -4.14F));

		ModelPartData tail = bs_vm_armadillo.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.4786F, -1.5223F));

		ModelPartData cube_r1 = tail.addChild("cube_r1", ModelPartBuilder.create().uv(35, 0).cuboid(-2.0F, -2.0F, -3.75F, 4.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.5303F, 1.5303F, -0.7854F, 0.0F, 0.0F));

		ModelPartData torso = bs_vm_armadillo.addChild("torso", ModelPartBuilder.create().uv(0, 24).cuboid(-6.5F, -7.5959F, -6.006F, 13.0F, 12.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0808F, -12.134F));

		ModelPartData right_front = torso.addChild("right_front", ModelPartBuilder.create().uv(19, 44).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, 4.4041F, -3.006F));

		ModelPartData left_front = torso.addChild("left_front", ModelPartBuilder.create().uv(43, 44).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, 4.4041F, -3.006F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.8113F, -6.3377F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(43, 45).cuboid(-1.0F, -2.0798F, -1.6011F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.3921F, 0.4717F, 0.7854F, 0.0F, 0.0F));

		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(13, 35).cuboid(-1.6321F, -7.4002F, -3.14F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.3921F, 0.4717F, 0.0F, 0.0F, -0.3927F));

		ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(7, 39).cuboid(-0.3679F, -7.4002F, -3.14F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.3921F, 0.4717F, 0.0F, 0.0F, 0.3927F));

		ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(20, 12).cuboid(-2.0F, -2.0883F, -5.3862F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.3921F, 0.4717F, -0.3927F, 0.0F, 0.0F));

		ModelPartData hitbox = bs_vm_armadillo.addChild("hitbox", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -3.0F, -9.0F, 18.0F, 16.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.6766F, -9.64F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(ArmadiloEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);
		this.animateMovement(ArmadiloAnimation.WALK, limbSwing, limbSwingAmount, 1f, 1f);
		this.updateAnimation(entity.idleAnimationState, ArmadiloAnimation.IDLE, ageInTicks, 1f);
	}


	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}


	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		this.bs_vm_armadillo.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return this.bs_vm_armadillo;
	}
}