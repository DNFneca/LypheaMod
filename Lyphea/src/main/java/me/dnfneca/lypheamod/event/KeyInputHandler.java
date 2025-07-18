package me.dnfneca.lypheamod.event;

import me.dnfneca.lypheamod.networking.ModMessages;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
	public static final String KEY_CATEGORY_TUTORIAL = "key.category.tutorialmod.tutorial";
	public static final String KEY_DRINK_WATER = "key.tutorialmod.drink_water";

	public static KeyBinding drinkingKey;

	public static void registerKeyInputs() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if(drinkingKey.wasPressed()) {
				// ClientPlayNetworking.send(ModMessages.EXAMPLE_ID, PacketByteBufs.create());
				PacketByteBuf buf = PacketByteBufs.create();
				buf.writeInt(1);
				ClientPlayNetworking.send(ModMessages.ADD_MANA_ID, buf);
			}
		});
	}

	public static void register() {
		drinkingKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				KEY_DRINK_WATER,
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_O,
				KEY_CATEGORY_TUTORIAL
		));

		registerKeyInputs();
	}
}