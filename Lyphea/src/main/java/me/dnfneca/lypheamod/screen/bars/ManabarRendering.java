package me.dnfneca.lypheamod.screen.bars;

import me.dnfneca.lypheamod.util.IEntityDataSaver;
import me.dnfneca.lypheamod.util.ManaData;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import static me.dnfneca.lypheamod.LypheaMod.MOD_ID;
import static me.dnfneca.lypheamod.LypheaModClient.client;
import static me.dnfneca.lypheamod.screen.RenderHandler.getCameraPlayer;

public class ManabarRendering {
	private static final Identifier fullManaBar = new Identifier(MOD_ID, "textures/gui/manabar/full.png");
	private static Identifier currentBar = fullManaBar;
	private static double intermediateMana = 0;
	private static final Identifier intermediateManaBar = new Identifier(MOD_ID, "textures/gui/manabar/intermediate.png");
	private static final Identifier emptyManaBar = new Identifier(MOD_ID, "textures/gui/manabar/empty.png");
	public static void renderManaBar(DrawContext context, float tickDelta, float x, float y, PlayerEntity player) {
		IEntityDataSaver playerData = (IEntityDataSaver) client.player;
		double mana = ManaData.getMana(playerData);
		double maxMana = 10;
		// Calculate bar proportions
		double healthProportion;
		double intermediateProportion;
		if (mana < intermediateMana) {
			healthProportion = mana / maxMana;
			intermediateProportion = (intermediateMana - mana) / maxMana;
		} else {
			healthProportion = intermediateMana / maxMana;
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
		context.drawTexture(intermediateManaBar,
				(int) x + healthWidth, (int) y,
				healthWidth, 0,
				intermediateWidth, 9,
				80, 9);
		// Display empty part
		context.drawTexture(emptyManaBar,
				(int) x + healthWidth + intermediateWidth, (int) y,
				healthWidth + intermediateWidth, 0,
				80 - healthWidth - intermediateWidth, 9,
				80, 9);
		// Update intermediate mana
		intermediateMana += (mana - intermediateMana) * tickDelta * 0.08;
		if (Math.abs(mana - intermediateMana) <= 0.25) {
			intermediateMana = mana;
		}
	}


//	// Get the Minecraft client
//
//		// Get the TextRenderer
//
//		// Draw a string on the screen
////		textRenderer.draw(context, "Hello, Fabric!", 10, 10, 0xFFFFFF);
//
//		// You can also use LiteralText to draw formatted text
////		textRenderer.draw(context, Text.of("Formatted Text"), 10, 30, 0xFFFFFF);
//
//	@Override
//	public void onHudRender(DrawContext drawContext, float tickDelta) {
//		int x = 0;
//		int y = 0;
//		MinecraftClient client = MinecraftClient.getInstance();
//		if (client != null) {
//			int width = client.getWindow().getScaledWidth();
//			int height = client.getWindow().getScaledHeight();
//
//			x = width / 2;
//			y = height;
//
//
//		}
//
//		RenderSystem.setShader(GameRenderer::getPositionColorTexProgram);
//		RenderSystem.defaultBlendFunc();
//		RenderSystem.setShader(GameRenderer::getPositionColorProgram);
//		RenderSystem.disableDepthTest();
//		for(int i = 0; i < 10; i++) {
//			RenderSystem.setShader(GameRenderer::getPositionColorTexProgram);
//			RenderSystem.defaultBlendFunc();
//			RenderSystem.setShader(GameRenderer::getPositionColorProgram);
//			RenderSystem.disableDepthTest();
//			drawContext.drawTexture(EMPTY_THIRST,x - 94 + (i * 10),y - 54,0,0,12,12,
//					12,12);
//
//		}
//		for(int i = 0; i < 10; i++) {
//			if(((IEntityDataSaver) MinecraftClient.getInstance().player).getPersistentData().getDouble("mana") > i) {
//				drawContext.drawTexture(FILLED_THIRST,x - 94 + (i * 10),y - 54,0,0,12,12,
//						12,12);
//			} else {
//				break;
//			}
//		}
//	}
}
