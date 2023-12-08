package me.dnfneca.lypheamod;

import me.dnfneca.lypheamod.entity.ModEntities;
import me.dnfneca.lypheamod.entity.custom.ArmadiloEntity;
import me.dnfneca.lypheamod.entity.custom.PorcupineEntity;
import me.dnfneca.lypheamod.event.PlayerTickHandler;
import me.dnfneca.lypheamod.networking.ModMessages;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class LypheaMod implements ModInitializer {

	/*
	 * Registers our Cube Entity under the ID "entitytesting:cube".
	 *
	 * The entity is registered under the SpawnGroup#CREATURE category, which is what most animals and passive/neutral mobs use.
	 * It has a hitbox size of .75x.75, or 12 "pixels" wide (3/4ths of a block).
	 */
	@Override
	public void onInitialize() {
		/*
		 * Register our Cube Entity's default attributes.
		 * Attributes are properties or stats of the mobs, including things like attack damage and health.
		 * The game will crash if the entity doesn't have the proper attributes registered in time.
		 *
		 * In 1.15, this was done by a method override inside the entity class.
		 * Most vanilla entities have a static method (eg. ZombieEntity#createZombieAttributes) for initializing their attributes.
		 */
//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_DOOR, RenderLayer.getCutout());
//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_TRAPDOOR, RenderLayer.getCutout());
//
//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout());
//
//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAHLIA, RenderLayer.getCutout());
//		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_DAHLIA, RenderLayer.getCutout());

		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.ARMADILO, ArmadiloEntity.createDragonAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.DRAGON, ArmadiloEntity.createDragonAttributes());
		ModMessages.registerC2SPackets();
//		ModMessages.registerS2CPackets();
		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}
