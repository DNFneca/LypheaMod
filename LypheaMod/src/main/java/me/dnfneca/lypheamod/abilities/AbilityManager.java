package me.dnfneca.lypheamod.abilities;

import me.dnfneca.lypheamod.utilities.IEntityDataSaver;
import me.dnfneca.lypheamod.utilities.ManaData;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;

import static me.dnfneca.lypheamod.abilities.baseabilities.Skillshot.listOfSkillshots;
import static me.dnfneca.lypheamod.abilities.baseabilities.Skillshot.skillshotTrash;
import static me.dnfneca.lypheamod.client.LypheaModClient.client;
import static me.dnfneca.lypheamod.utilities.ManaData.getMana;
import static me.dnfneca.lypheamod.utilities.ManaData.removeMana;

public class AbilityManager {
	public static void use(ServerPlayerEntity serverPlayerEntity, String abilityName) {
		IEntityDataSaver playerData = (IEntityDataSaver) serverPlayerEntity;
		double mana = getMana(playerData);
		serverPlayerEntity.sendMessage(Text.of(String.valueOf(mana)));
		ServerWorld world = (ServerWorld) serverPlayerEntity.getWorld();
		switch (abilityName) {
			case "manaDrain":
				if (mana >= 2) {
					removeMana(playerData, 2);
					new ManaDrain(serverPlayerEntity);
					world.playSound(null, serverPlayerEntity.getBlockPos(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS,
                        0.5F, world.random.nextFloat() * 0.1F + 0.9F);
//					client.player.getWorld().addParticle(ParticleTypes.HEART, true, serverPlayerEntity.getX(), serverPlayerEntity.getY() + 1, serverPlayerEntity.getZ(), 0, 0, 0);
//		            removeMana(((IEntityDataSaver) player), 1);

				} else {
					world.playSound(null, serverPlayerEntity.getBlockPos(), SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.MASTER,
							0.5F, serverPlayerEntity.getWorld().random.nextFloat() * 0.1F + 0.9F);
				}
				break;
		}
	}
	public static void tick() {
		listOfSkillshots.forEach(skillshot -> {
			skillshot.tick();
		});
		cleanup();
	}
	private static void cleanup() {
		listOfSkillshots.removeAll(skillshotTrash);
	}
}
