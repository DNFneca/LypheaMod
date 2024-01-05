package me.dnfneca.lypheamod.screen.bars;


import me.dnfneca.lypheamod.screen.TextToScreen;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import static me.dnfneca.lypheamod.LypheaMod.MOD_ID;


public class HealthbarRenderer {


	private static final Identifier fullHealthBar = new Identifier(MOD_ID, "textures/gui/healthbar/full.png");
	private static final Identifier witherHealthBar = new Identifier(MOD_ID, "textures/gui/healthbar/wither.png");
	private static final Identifier poisonHealthBar = new Identifier(MOD_ID, "textures/gui/healthbar/poison.png");
	private static final Identifier frozenHealthBar = new Identifier(MOD_ID, "textures/gui/healthbar/frozen.png");
	private static Identifier currentBar = fullHealthBar;
	private static final Identifier intermediateHealthBar = new Identifier(MOD_ID, "textures/gui/healthbar/intermediate.png");
	private static final Identifier emptyHealthBar = new Identifier(MOD_ID, "textures/gui/healthbar/empty.png");
	private static final Identifier absorptionBar = new Identifier(MOD_ID, "textures/gui/healthbar/absorption.png");
	private static final Identifier heartContainer = new Identifier(MOD_ID, "textures/gui/healthbar/container.png");
	private static final Identifier absorptionHeart = new Identifier(MOD_ID, "textures/gui/healthbar/absorbing_full.png");
	private static double intermediateHealth = 0;
	public static void updateBarTextures(PlayerEntity player) {
		if (player.hasStatusEffect(StatusEffects.WITHER)) {
			currentBar = witherHealthBar;
		} else if (player.hasStatusEffect(StatusEffects.POISON)) {
			currentBar = poisonHealthBar;
		} else if (player.isFrozen()) {
			currentBar = frozenHealthBar;
		} else {
			currentBar = fullHealthBar;
		}
	}

	public static void renderHealthValue(TextRenderer textRenderer, DrawContext context, int x, int y, PlayerEntity player) {
		double health = Math.ceil(player.getHealth() * 10) / 10;
		String text = health + "/" + (int) player.getMaxHealth();
		text = text.replace(".0", "");
//		new TextRenderRequest(text, x - textRenderer.getWidth(text) - 6, y + 1, 200, 0xFF0000, false);
		TextToScreen.render(text, x - textRenderer.getWidth(text) - 6, y + 1, context, 0xFF0000, false);
//		context.drawText(textRenderer, text, x - textRenderer.getWidth(text) - 6, y + 1, 0xFF0000, false);
	}

	public static void renderHealthBar(DrawContext context, float tickDelta, float x, float y, PlayerEntity player) {
		float health = player.getHealth();
		float maxHealth = player.getMaxHealth();
		// Calculate bar proportions
		double healthProportion;
		double intermediateProportion;
		if (health < intermediateHealth) {
			healthProportion = health / maxHealth;
			intermediateProportion = (intermediateHealth - health) / maxHealth;
		} else {
			healthProportion = intermediateHealth / maxHealth;
			intermediateProportion = 0;
		}
		if (healthProportion > 1) healthProportion = 1F;
		if (healthProportion + intermediateProportion > 1) intermediateProportion = 1 - healthProportion;
		int healthWidth = (int) Math.ceil(80 * healthProportion);
		int intermediateWidth = (int) Math.ceil(80 * intermediateProportion);
		// Display full part
		context.drawTexture(currentBar,
				(int) x, (int) y,
				0, 0,
				healthWidth, 9,
				80, 9);
		// Display intermediate part
		context.drawTexture(intermediateHealthBar,
				(int) x + healthWidth, (int) y,
				healthWidth, 0,
				intermediateWidth, 9,
				80, 9);
		// Display empty part
		context.drawTexture(emptyHealthBar,
				(int) x + healthWidth + intermediateWidth, (int) y,
				healthWidth + intermediateWidth, 0,
				80 - healthWidth - intermediateWidth, 9,
				80, 9);
		// Update intermediate health
		intermediateHealth += (health - intermediateHealth) * tickDelta * 0.08;
		if (Math.abs(health - intermediateHealth) <= 0.25) {
			intermediateHealth = health;
		}
	}

	public static void renderAbsorptionValue(TextRenderer textRenderer, DrawContext context, int x, int y, PlayerEntity player) {
		double absorption = Math.ceil(player.getAbsorptionAmount());
		String text = String.valueOf(absorption / 2);
		text = text.replace(".0", "");
		context.drawText(textRenderer, text, x - textRenderer.getWidth(text) - 16, y - 9, 0xFFFF00, false);
		// blit heart container

		context.drawTexture(heartContainer,
				x - 16, y - 10,
				0, 0,
				9, 9,
				9, 9);
		// blit heart
		context.setShaderColor(127F, 127F, 0F, 0.5F);
		context.drawTexture(absorptionHeart,
				x - 16, y - 10,
				0, 0,
				9, 9,
				9, 9);
		context.setShaderColor(1F, 1F, 1F, 1F);
	}

	public static void renderAbsorptionBar(DrawContext context, float x, float y, PlayerEntity player) {
		float absorption = player.getAbsorptionAmount();
		float maxHealth = player.getMaxHealth();
		// Calculate bar proportions
		float absorptionProportion = absorption / maxHealth;
		if (absorptionProportion > 1) absorptionProportion = 1F;
		int absorptionWidth = (int) Math.ceil(80 * absorptionProportion);
		// Display full part
		context.drawTexture(absorptionBar,
				(int) x, (int) y - 10,
				0, 0,
				absorptionWidth, 9,
				80, 9);
		// Display empty part
		context.drawTexture(emptyHealthBar,
				(int) x + absorptionWidth, (int) y - 10,
				absorptionWidth, 0,
				80 - absorptionWidth, 9,
				80, 9);
	}
}
