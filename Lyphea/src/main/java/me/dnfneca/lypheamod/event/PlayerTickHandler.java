package me.dnfneca.lypheamod.event;

import me.dnfneca.lypheamod.abilities.AbilityManager;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;

public class PlayerTickHandler implements ServerTickEvents.StartTick {
	@Override
	public void onStartTick(MinecraftServer server) {
		AbilityManager.tick();
//		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
//			if(new Random().nextFloat() <= 0.005f) {
//				IEntityDataSaver dataPlayer = ((IEntityDataSaver) player);
//				ManaData.removeMana(dataPlayer,1);
//			}
//		}
	}
}