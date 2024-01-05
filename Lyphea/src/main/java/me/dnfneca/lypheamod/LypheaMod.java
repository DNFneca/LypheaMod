package me.dnfneca.lypheamod;

import me.dnfneca.lypheamod.block.ModBlocks;
import me.dnfneca.lypheamod.block.entity.ModBlockEntities;
import me.dnfneca.lypheamod.entity.ModBoats;
import me.dnfneca.lypheamod.entity.ModEntities;
import me.dnfneca.lypheamod.entity.custom.PorcupineEntity;
import me.dnfneca.lypheamod.event.PlayerTickHandler;
import me.dnfneca.lypheamod.item.ModItemGroups;
import me.dnfneca.lypheamod.item.ModItems;
import me.dnfneca.lypheamod.networking.ModMessages;
import me.dnfneca.lypheamod.recipe.ModRecipes;
import me.dnfneca.lypheamod.screen.ModScreenHandlers;
import me.dnfneca.lypheamod.sound.ModSounds;
import me.dnfneca.lypheamod.util.ModCustomTrades;
import me.dnfneca.lypheamod.util.ModLootTableModifiers;
import me.dnfneca.lypheamod.villager.ModVillagers;
import me.dnfneca.lypheamod.world.gen.ModWorldGeneration;
import me.dnfneca.lypheamod.world.tree.ModFoliagePlacerTypes;
import me.dnfneca.lypheamod.world.tree.ModTrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static me.dnfneca.lypheamod.world.gen.ModWorldGeneration.generateModWorldGen;

public class LypheaMod implements ModInitializer {
	public static final String MOD_ID = "lypheamod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModVillagers.registerVillagers();
		ModSounds.registerSounds();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();
		ModTrunkPlacerTypes.register();

		ModMessages.registerC2SPackets();
//		ModMessages.registerS2CPackets();
		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());

		ModFoliagePlacerTypes.register();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());

		StrippableBlockRegistry.register(ModBlocks.CHESTNUT_LOG, ModBlocks.STRIPPED_CHESTNUT_LOG);
		StrippableBlockRegistry.register(ModBlocks.CHESTNUT_WOOD, ModBlocks.STRIPPED_CHESTNUT_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHESTNUT_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHESTNUT_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHESTNUT_LEAVES, 30, 60);

		ModBoats.registerBoats();
		generateModWorldGen();

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.RUBY_BLOCK)
				.lightWithItem(ModItems.CORN)
				.destDimID(new Identifier(LypheaMod.MOD_ID, "kaupendim"))
				.tintColor(0xc76efa)
				.registerPortal();
	}
}