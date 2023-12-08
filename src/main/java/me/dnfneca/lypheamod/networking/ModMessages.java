package me.dnfneca.lypheamod.networking;

import me.dnfneca.lypheamod.networking.packet.ExampleC2SPacket;
import me.dnfneca.lypheamod.networking.packet.ItemStackSyncS2CPacket;
import me.dnfneca.lypheamod.networking.packet.ManaC2SPacket;
import me.dnfneca.lypheamod.networking.packet.ManaSyncDataS2CPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

import static me.dnfneca.lypheamod.client.LypheaModClient.MOD_ID;

public class ModMessages {
	public static final Identifier MANA_ID = new Identifier(MOD_ID, "mana");
	public static final Identifier MANA_SYNC_ID = new Identifier(MOD_ID, "mana_sync");
	public static final Identifier EXAMPLE_ID = new Identifier(MOD_ID, "example");

//	public static final Identifier ENERGY_SYNC = new Identifier(TutorialMod.MOD_ID, "energy_sync");
//	public static final Identifier FLUID_SYNC = new Identifier(TutorialMod.MOD_ID, "fluid_sync");
	public static final Identifier ITEM_SYNC = new Identifier(MOD_ID, "item_sync");
	public static void registerC2SPackets() {
		ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
		ServerPlayNetworking.registerGlobalReceiver(MANA_ID, ManaC2SPacket::receive);
	}

	@Environment(EnvType.CLIENT)
	public static void registerS2CPackets() {
		ClientPlayNetworking.registerGlobalReceiver(MANA_SYNC_ID, ManaSyncDataS2CPacket::receive);
//		ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
//		ClientPlayNetworking.registerGlobalReceiver(FLUID_SYNC, FluidSyncS2CPacket::receive);
//		ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC, ItemStackSyncS2CPacket::receive);
	}
}