package me.dnfneca.lypheamod.utilities;

import me.dnfneca.lypheamod.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class ManaData {
	public static double addMana(IEntityDataSaver player, int amount) {
		NbtCompound nbt = player.getPersistentData();
		double mana = nbt.getDouble("mana");
		if(mana + amount >= 10) {
			mana = 10;
		} else {
			mana += amount;
		}

		nbt.putDouble("mana", mana);
		syncMana(mana, (ServerPlayerEntity) player);
		return mana;
	}

	public static double removeMana(IEntityDataSaver player, int amount) {
		NbtCompound nbt = player.getPersistentData();
		double mana = nbt.getDouble("mana");
		if(mana - amount < 0) {
			mana = 0;
		} else {
			mana -= amount;
		}

		nbt.putDouble("mana", mana);
		syncMana(mana, (ServerPlayerEntity) player);
		return mana;
	}

	public static double getMana(IEntityDataSaver player) {
		NbtCompound nbt = player.getPersistentData();
		return nbt.getDouble("mana");
	}

	public static double getMaxMana(IEntityDataSaver player) {
		NbtCompound nbt = player.getPersistentData();
		return nbt.getDouble("mana");
	}

	public static void syncMana(double mana, ServerPlayerEntity player) {
		PacketByteBuf buffer = PacketByteBufs.create();
		buffer.writeDouble(mana);
		ServerPlayNetworking.send(player, ModMessages.MANA_SYNC_ID, buffer);
	}

}