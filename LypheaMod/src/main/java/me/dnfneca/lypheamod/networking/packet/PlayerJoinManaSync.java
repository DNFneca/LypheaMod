package me.dnfneca.lypheamod.networking.packet;

import me.dnfneca.lypheamod.networking.ModMessages;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.event.server.ServerStartCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;

public class PlayerJoinManaSync implements ClientPlayConnectionEvents.Join {
	public void onPlayInit(ServerPlayNetworkHandler handler, MinecraftServer server) {
		ClientPlayNetworking.send(ModMessages.SYNC_MANA_ID, PacketByteBufs.create());
	}

	@Override
	public void onPlayReady(ClientPlayNetworkHandler handler, PacketSender sender, MinecraftClient client) {
		ClientPlayNetworking.send(ModMessages.SYNC_MANA_ID, PacketByteBufs.create());
	}
}
