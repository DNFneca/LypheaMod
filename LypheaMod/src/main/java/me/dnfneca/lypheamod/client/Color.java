package me.dnfneca.lypheamod.client;

/**
 * Runs the mod initializer on the client environment.
 */

public enum Color {
	GRAY,RED,GREEN,YELLOW,DARK_RED,GOLD,DARK_GREEN,AQUA,DARK_AQUA,DARK_BLUE,BLUE,LIGHT_PURPLE,DARK_PURPLE,WHITE,DARK_GRAY,BLACK;

	public static String Color(Color color) {
		switch (color) {
			case DARK_RED -> {
				return "§4";
			}
			case RED -> {
				return "§c";
			}
			case GOLD -> {
				return "§6";
			}
			case YELLOW -> {
				return "§e";
			}
			case DARK_GREEN -> {
				return "§2";
			}
			case GREEN -> {
				return "§a";
			}
			case GRAY -> {
				return "§7";
			}
			case AQUA -> {
				return "§b";
			}
			case DARK_AQUA -> {
				return "§3";
			}
			case DARK_BLUE -> {
				return "§1";
			}
			case BLUE -> {
				return "§9";
			}
			case LIGHT_PURPLE -> {
				return "§d";
			}
			case DARK_PURPLE -> {
				return "§5";
			}
			case WHITE -> {
				return "§f";
			}
			case DARK_GRAY -> {
				return "§8";
			}
			case BLACK -> {
				return "§0";
			}
			default -> {
				return "§7";
			}
		}
	}
}

