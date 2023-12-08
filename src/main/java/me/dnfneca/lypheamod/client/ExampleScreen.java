package me.dnfneca.lypheamod.client;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import me.dnfneca.lypheamod.utilities.IEntityDataSaver;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

import static me.dnfneca.lypheamod.client.LypheaModClient.MOD_ID;

public class ExampleScreen implements HudRenderCallback {
	private static final Identifier FILLED_THIRST = new Identifier(MOD_ID,
			"textures/mana/full_mana.png");
	private static final Identifier EMPTY_THIRST = new Identifier(MOD_ID,
			"textures/mana/empty_mana.png");

	// Get the Minecraft client

		// Get the TextRenderer

		// Draw a string on the screen
//		textRenderer.draw(context, "Hello, Fabric!", 10, 10, 0xFFFFFF);

		// You can also use LiteralText to draw formatted text
//		textRenderer.draw(context, Text.of("Formatted Text"), 10, 30, 0xFFFFFF);

	@Override
	public void onHudRender(DrawContext drawContext, float tickDelta) {
		int windowHeight = MinecraftClient.getInstance().getWindow().getScaledHeight();
		int windowWidth = MinecraftClient.getInstance().getWindow().getScaledWidth();

		RenderSystem.setShader(GameRenderer::getPositionTexProgram);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
		drawContext.drawText(textRenderer, "Mana", (int) (windowWidth/1.25), windowHeight-15, 0x194D33, false);

		int x = 0;
		int y = 0;
		MinecraftClient client = MinecraftClient.getInstance();
		if (client != null) {
			int width = client.getWindow().getScaledWidth();
			int height = client.getWindow().getScaledHeight();

			x = width / 2;
			y = height;
		}


		for(int i = 0; i < 10; i++) {
			drawContext.drawTexture(EMPTY_THIRST,x - 94 + (i * 9),y - 54,0,0,12,12,
					12,12);
		}
		for(int i = 0; i < 10; i++) {
			if(((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getDouble("mana") > i) {
				drawContext.drawTexture(FILLED_THIRST,x - 94 + (i * 9),y - 54,0,0,12,12,
						12,12);
			} else {
				break;
			}
		}
	}
}
