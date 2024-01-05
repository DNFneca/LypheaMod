package me.dnfneca.lypheamod.abilities;

import me.dnfneca.lypheamod.abilities.baseabilities.Ability;
import me.dnfneca.lypheamod.util.IEntityDataSaver;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;

import static java.lang.StrictMath.max;
import static me.dnfneca.lypheamod.LypheaModClient.EQUIP_ROBE_1_EVENT;
import static me.dnfneca.lypheamod.LypheaModClient.client;
import static me.dnfneca.lypheamod.abilities.baseabilities.Ability.abilitiesTrash;
import static me.dnfneca.lypheamod.abilities.baseabilities.Ability.listOfAbilities;
import static me.dnfneca.lypheamod.util.ManaData.getMana;
import static me.dnfneca.lypheamod.util.ManaData.*;

public class AbilityManager {
	public static void tryToCast(ServerPlayerEntity serverPlayerEntity, String abilityName) {
		IEntityDataSaver playerData = (IEntityDataSaver) serverPlayerEntity;
		double mana = getMana(playerData);
		serverPlayerEntity.sendMessage(Text.of(String.valueOf(mana)));
		ServerWorld world = (ServerWorld) serverPlayerEntity.getWorld();
		switch (abilityName) {
			case "ManaDrain":
				if (mana >= 2) {
					removeMana(playerData, 2);
					new ManaDrain(serverPlayerEntity);
					world.playSound(null, serverPlayerEntity.getBlockPos(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS,
							0.5F, world.random.nextFloat() * 0.1F + 0.9F);
//					client.player.getWorld().addParticle(ParticleTypes.HEART, true, serverPlayerEntity.getX(), serverPlayerEntity.getY() + 1, serverPlayerEntity.getZ(), 0, 0, 0);
//		            removeMana(((IEntityDataSaver) player), 1);

				} else {
					world.playSound(null, serverPlayerEntity.getBlockPos(), SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.MASTER,
							0.5F, serverPlayerEntity.getWorld().random.nextFloat() * 0.1F + 0.9F);
				}
				break;
			case "TestAbility":
				double neededMana = max(getMaxMana(playerData) / 10, 1);
				client.player.sendMessage(Text.of(String.valueOf(neededMana)));
				if(mana >= neededMana) {
					removeMana(playerData, (int) neededMana);
					new TestAbility(serverPlayerEntity);
					client.player.getWorld().playSound(
							null, // Player - if non-null, will play sound for every nearby player *except* the specified player
							serverPlayerEntity.getBlockPos(), // The position of where the sound will come from
							EQUIP_ROBE_1_EVENT, // The sound that will play
							SoundCategory.MASTER, // This determines which of the volume sliders affect this sound
							1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
							1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
					);
				}
		}
	}
	public static void tick() {
		listOfAbilities.forEach(Ability::tick);
		cleanup();
	}
	private static Float hasEnoughMana(String manaCost, double availableMana) {
		if (manaCost.contains("abs(")) {
			float actualManaCost = Float.parseFloat(manaCost.split("abs[(]")[1].split("[)]")[0]);
			return actualManaCost > availableMana ? null : actualManaCost;
		} else {
			return null;
		}
	}
	private static void cleanup() {
		listOfAbilities.removeAll(abilitiesTrash);
	}
}
