package me.dnfneca.lypheamod.client;

import me.dnfneca.lypheamod.blocks.ExampleBlock;
import me.dnfneca.lypheamod.entity.ModEntities;
import me.dnfneca.lypheamod.entity.client.*;
import me.dnfneca.lypheamod.event.KeyInputHandler;
import me.dnfneca.lypheamod.networking.ModMessages;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LypheaModClient implements ClientModInitializer {

	public static final String MOD_ID = "lypheamod";
	private static final Block EXAMPLE_BLOCK = new ExampleBlock(FabricBlockSettings.create().strength(4.0f));
	private static final Item EXAMPLE_ITEM = new Item(new Item.Settings().maxCount(1));
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(EXAMPLE_ITEM))
			.displayName(Text.translatable("itemGroup.lypheamod.test_group"))
			.entries((context, entries) -> {
				entries.add(EXAMPLE_ITEM);
			})
			.build();



	@Override
	public void onInitializeClient() {
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "example_block"), EXAMPLE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "example_block"), EXAMPLE_ITEM);
		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "test_group"), ITEM_GROUP);
		EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.ARMADILO, ArmadiloRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ARMADILO, ArmadiloModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.DRAGON, DragonRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DRAGON, DragonModel::getTexturedModelData);
		KeyInputHandler.register();
		ModMessages.registerC2SPackets();
		ModMessages.registerS2CPackets();
		HudRenderCallback.EVENT.register(new ExampleScreen());

	}
}
