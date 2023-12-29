package me.dnfneca.lypheamod.client.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

import static me.dnfneca.lypheamod.client.LypheaModClient.MOD_ID;
import static me.dnfneca.lypheamod.client.LypheaModClient.client;
import static me.dnfneca.lypheamod.client.render.RenderHandler.getCameraPlayer;


public class HungerbarRenderer {

	private static final Identifier FOOD_EMPTY_HUNGER_TEXTURE = new Identifier(MOD_ID, "textures/gui/hungerbar/food_empty_hunger");
	private static final Identifier FOOD_HALF_HUNGER_TEXTURE = new Identifier(MOD_ID, "textures/gui/hungerbar/food_half_hunger");
	private static final Identifier FOOD_FULL_HUNGER_TEXTURE = new Identifier(MOD_ID, "textures/gui/hungerbar/food_full_hunger");
	private static final Identifier FOOD_EMPTY_TEXTURE = new Identifier(MOD_ID, "textures/gui/hungerbar/food_empty.png");
	private static final Identifier FOOD_HALF_TEXTURE = new Identifier(MOD_ID, "textures/gui/hungerbar/food_half");
	private static final Identifier FOOD_FULL_TEXTURE = new Identifier(MOD_ID, "textures/gui/hungerbar/food_full.png");
	private static final Identifier AIR_TEXTURE = new Identifier("hud/air");
	private static final Identifier AIR_BURSTING_TEXTURE = new Identifier("hud/air_bursting");


	private static int ticks;


	public static void render(DrawContext dc) {
		++ticks;

		int scaledWidth = client.getWindow().getScaledWidth();
		int scaledHeight = client.getWindow().getScaledHeight();
		Random random = new Random();
		int aa;
		int z;
		int y;
		PlayerEntity playerEntity = getCameraPlayer();
		if (playerEntity == null) {
			return;
		}

		random.setSeed((long) (ticks * 312871));
		HungerManager hungerManager = playerEntity.getHungerManager();
		int k = hungerManager.getFoodLevel();
		int n = scaledWidth / 2 + 91;
		int o = scaledHeight - 39 - 10;

		client.getProfiler().swap("food");
		for (y = 0; y < 10; ++y) {
			Identifier identifier3;
			Identifier identifier2;
			Identifier identifier;
			z = o;
			if (playerEntity.hasStatusEffect(StatusEffects.HUNGER)) {
				identifier = FOOD_EMPTY_HUNGER_TEXTURE;
				identifier2 = FOOD_HALF_HUNGER_TEXTURE;
				identifier3 = FOOD_FULL_HUNGER_TEXTURE;
			} else {
				identifier = FOOD_EMPTY_TEXTURE;
				identifier2 = FOOD_HALF_TEXTURE;
				identifier3 = FOOD_FULL_TEXTURE;
			}
			if (playerEntity.getHungerManager().getSaturationLevel() <= 0.0f && ticks % (k * 3 + 1) == 0) {
				z += random.nextInt(3) - 1;
			}
			aa = n - y * 8 - 9;
			dc.drawTexture(identifier, aa, z, 0, 0, 9, 9, 9, 9);
			if (y * 2 + 1 < k) {
				dc.drawTexture(identifier3, aa, z, 0, 0, 9, 9, 9, 9);
			}
			if (y * 2 + 1 != k) continue;
			dc.drawTexture(identifier2, aa, z, 0, 0, 9, 9, 9, 9);
		}
		client.getProfiler().pop();
	}



}

