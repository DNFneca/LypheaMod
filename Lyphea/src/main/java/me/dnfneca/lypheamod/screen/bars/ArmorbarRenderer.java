package me.dnfneca.lypheamod.screen.bars;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

import static me.dnfneca.lypheamod.LypheaMod.MOD_ID;
import static me.dnfneca.lypheamod.LypheaModClient.client;
import static me.dnfneca.lypheamod.screen.RenderHandler.getCameraPlayer;

public class ArmorbarRenderer {

	private static final Identifier ARMOR_EMPTY_TEXTURE = new Identifier(MOD_ID,"textures/gui/armorbar/armor_empty.png");
	private static final Identifier ARMOR_HALF_TEXTURE = new Identifier(MOD_ID, "textures/gui/armorbar/armor_half.png");
	private static final Identifier ARMOR_FULL_TEXTURE = new Identifier(MOD_ID, "textures/gui/armorbar/armor_full.png");
	private static int ticks;
	private static int renderHealthValue;


	public static void render(DrawContext dc) {

		++ticks;

		int scaledWidth = client.getWindow().getScaledWidth();
		int scaledHeight = client.getWindow().getScaledHeight();
		Random random = new Random();
		int x;
		PlayerEntity playerEntity = getCameraPlayer();
		if (playerEntity == null) {
			return;
		}

		int i = MathHelper.ceil((float) playerEntity.getHealth());
		int j = renderHealthValue;
		random.setSeed((long) (ticks * 312871));
		HungerManager hungerManager = playerEntity.getHungerManager();
		int m = scaledWidth / 2 - 91;
		int o = scaledHeight - 39;
		float f = Math.max((float) playerEntity.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH), (float) Math.max(j, i));
		int p = MathHelper.ceil((float) playerEntity.getAbsorptionAmount());
		int q = MathHelper.ceil((float) ((f + (float) p) / 2.0f / 10.0f));
		int r = Math.max(10 - (q - 2), 3);
		int s = o - (q - 1) * r - 10;
		int u = playerEntity.getArmor();

		client.getProfiler().push("armor");
		for (int w = 0; w < 10; ++w) {
			if (u <= 0) continue;
			x = m + w * 8;
			if (w * 2 + 1 < u) {
				dc.drawTexture(ARMOR_FULL_TEXTURE, x, s, 0, 0, 9, 9, 9, 9);
			}
			if (w * 2 + 1 == u) {
				dc.drawTexture(ARMOR_HALF_TEXTURE, x, s, 0, 0, 9, 9, 9, 9);
			}
			if (w * 2 + 1 <= u) continue;
			dc.drawTexture(ARMOR_EMPTY_TEXTURE, x, s, 0, 0, 9, 9, 9, 9);
		}
		client.getProfiler().pop();
	}

}
