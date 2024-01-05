package me.dnfneca.lypheamod.screen;

import me.dnfneca.lypheamod.screen.bars.ArmorbarRenderer;
import me.dnfneca.lypheamod.screen.bars.HungerbarRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;

import static me.dnfneca.lypheamod.LypheaModClient.client;
import static me.dnfneca.lypheamod.screen.bars.HealthbarRenderer.*;
import static me.dnfneca.lypheamod.screen.bars.ManabarRendering.renderManaBar;

public class RenderHandler {

	public static void render(DrawContext context, float tickDelta) {
		if (client.cameraEntity instanceof PlayerEntity player
				&& !client.options.hudHidden
				&& client.interactionManager != null && client.interactionManager.hasStatusBars()) {
			int width = client.getWindow().getScaledWidth();
			int height = client.getWindow().getScaledHeight();
			float x = (float) width / 2 - 91;
			float y = height - 39;
			TextRenderer textRenderer = client.textRenderer;
			updateBarTextures(player);
			TextToScreen.tick(context);
			HungerbarRenderer.render(context);
			ArmorbarRenderer.render(context);
			renderManaBar(context, tickDelta, x + 101, y, player);
			renderHealthValue(textRenderer, context, (int) x, (int) y, player);
			renderHealthBar(context, tickDelta, x, y, player);
			if (player.getAbsorptionAmount() > 0) {
				renderAbsorptionValue(textRenderer, context, (int) x, (int) y, player);
				renderAbsorptionBar(context, x, y, player);
			}
		}
	}

	public static PlayerEntity getCameraPlayer() {
		MinecraftClient client = MinecraftClient.getInstance();
		return !(client.getCameraEntity() instanceof PlayerEntity) ? null : (PlayerEntity) client.getCameraEntity();
	}

}
