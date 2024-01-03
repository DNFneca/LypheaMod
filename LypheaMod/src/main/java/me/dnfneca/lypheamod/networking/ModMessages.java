package me.dnfneca.lypheamod.networking;

import me.dnfneca.lypheamod.networking.packet.ExampleC2SPacket;
import me.dnfneca.lypheamod.networking.packet.ManaC2SPacket;
import me.dnfneca.lypheamod.networking.packet.ManaSyncDataS2CPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

import static me.dnfneca.lypheamod.client.LypheaModClient.MOD_ID;

public class ModMessages {
	public static final Identifier ADD_MANA_ID = new Identifier(MOD_ID, "add_mana");
	public static final Identifier SYNC_MANA_ID = new Identifier(MOD_ID, "sync_mana");
	public static final Identifier CAST_ABILITY_ID = new Identifier(MOD_ID, "cast_ability");
	public static final Identifier REMOVE_MANA_ID = new Identifier(MOD_ID, "remove_mana");
	public static final Identifier MANA_SYNC_ID = new Identifier(MOD_ID, "mana_sync");

//	public static final Identifier ENERGY_SYNC = new Identifier(TutorialMod.MOD_ID, "energy_sync");
//	public static final Identifier FLUID_SYNC = new Identifier(TutorialMod.MOD_ID, "fluid_sync");
	public static final Identifier ITEM_SYNC = new Identifier(MOD_ID, "item_sync");
	public static void registerC2SPackets() {
		ServerPlayNetworking.registerGlobalReceiver(ADD_MANA_ID, ManaC2SPacket::add);
		ServerPlayNetworking.registerGlobalReceiver(CAST_ABILITY_ID, ManaC2SPacket::castability);
		ServerPlayNetworking.registerGlobalReceiver(REMOVE_MANA_ID, ManaC2SPacket::remove);
		ServerPlayNetworking.registerGlobalReceiver(SYNC_MANA_ID, ManaC2SPacket::sync);
	}

	@Environment(EnvType.CLIENT)
	public static void registerS2CPackets() {
		ClientPlayNetworking.registerGlobalReceiver(MANA_SYNC_ID, ManaSyncDataS2CPacket::receive);
//		ServerPlayNetworking.registerGlobalReceiver(MANA_ID, ManaC2SPacket::receive);

//		ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
//		ClientPlayNetworking.registerGlobalReceiver(FLUID_SYNC, FluidSyncS2CPacket::receive);
//		ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC, ItemStackSyncS2CPacket::receive);
	}
}