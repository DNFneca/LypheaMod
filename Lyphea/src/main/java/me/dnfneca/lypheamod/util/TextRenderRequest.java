package me.dnfneca.lypheamod.util;

import static me.dnfneca.lypheamod.LypheaModClient.TextRenderRequestQueue;

public class TextRenderRequest {

	public class TextRequestToRender{
		private String textToRender;
		private int newX;
		private int newY;
		private int timerActive;
		private boolean shadow;
		private int color;
		public TextRequestToRender(String text, int x, int y, int timer) {
			this.textToRender = text;
			this.newX = x;
			this.newY = y;
			this.timerActive = timer;
			this.color = 0xFF0000;
			this.shadow=false;
		}
		public TextRequestToRender(String text, int x, int y, int timer, int color, boolean shadow) {
			this.textToRender = text;
			this.newX = x;
			this.newY = y;
			this.timerActive = timer;
			this.color = color;
			this.shadow = shadow;
		}

		public boolean isShadow() {
			return this.shadow;
		}

		public void setShadow(final boolean shadow) {
			this.shadow = shadow;
		}

		public int getColor() {
			return this.color;
		}

		public void setColor(final int color) {
			this.color = color;
		}

		public int getX() {
			return this.newX;
		}

		public int getY() {
			return this.newY;
		}

		public void setTimerActive(final int timerActive) {
			this.timerActive = timerActive;
		}

		public int getTimerActive() {
			return this.timerActive;
		}

		public String getTextToRender() {
			return this.textToRender;
		}
	}
	public TextRenderRequest(String textToWriteToScreen, int x, int y, int timer) {
		TextRenderRequestQueue.add(new TextRequestToRender(textToWriteToScreen, x, y, timer));
	}
	public TextRenderRequest(String textToWriteToScreen, int x, int y, int timer, int color, boolean shadow) {
		TextRenderRequestQueue.add(new TextRequestToRender(textToWriteToScreen, x, y, timer,color , shadow));
	}
}
