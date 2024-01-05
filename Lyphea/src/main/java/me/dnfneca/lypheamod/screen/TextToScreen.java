package me.dnfneca.lypheamod.screen;

import me.dnfneca.lypheamod.util.TextRenderRequest;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

import java.util.ArrayList;

import static me.dnfneca.lypheamod.LypheaModClient.TextRenderRequestQueue;
import static me.dnfneca.lypheamod.LypheaModClient.client;

public class TextToScreen{
	private static ArrayList<TextRenderRequest.TextRequestToRender> Trash = new ArrayList<>();
	public static void render(Text textToRender, int x, int y, DrawContext context, int color, boolean shadow) {
		TextRenderer textRenderer = client.textRenderer;
		context.drawText(textRenderer, textToRender, x, y, color, shadow);
	}

	public static void tick(DrawContext context) {
		TextRenderer textRenderer = client.textRenderer;
		for(TextRenderRequest.TextRequestToRender requestToRender: TextRenderRequestQueue) {
			requestToRender.setTimerActive(requestToRender.getTimerActive() - 1);
			if(requestToRender.getTimerActive() > 0) {
				context.drawText(textRenderer, requestToRender.getTextToRender(), requestToRender.getX(), requestToRender.getY(), requestToRender.getColor(), requestToRender.isShadow());
			} else if(requestToRender.getTimerActive() < -200) {
				Trash.add(requestToRender);
			}
		}
		TextRenderRequestQueue.removeAll(Trash);
	}

	public static void render(String textToRender, int x, int y, DrawContext context, int color, boolean shadow) {
		TextRenderer textRenderer = client.textRenderer;
		context.drawText(textRenderer, textToRender, x, y, color, shadow);
	}
}
