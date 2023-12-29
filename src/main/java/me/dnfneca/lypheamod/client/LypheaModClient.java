package me.dnfneca.lypheamod.client;

import com.mojang.logging.LogUtils;
import me.dnfneca.lypheamod.blocks.ExampleBlock;
import me.dnfneca.lypheamod.entity.ModEntities;
import me.dnfneca.lypheamod.entity.client.*;
import me.dnfneca.lypheamod.event.KeyInputHandler;
import me.dnfneca.lypheamod.event.PlayerTickHandler;
import me.dnfneca.lypheamod.items.Wand;
import me.dnfneca.lypheamod.networking.ModMessages;
import me.dnfneca.lypheamod.networking.packet.PlayerJoinManaSync;
import me.dnfneca.lypheamod.utilities.TextRenderRequest;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.slf4j.Logger;

import java.util.ArrayList;

import static net.minecraft.registry.RegistryKeys.DAMAGE_TYPE;


@Environment(EnvType.CLIENT)
public class LypheaModClient implements ClientModInitializer {

	public static final String MOD_ID = "lypheamod";

	public static final Logger LOGGER = LogUtils.getLogger();

	public static final MinecraftClient client = MinecraftClient.getInstance();
	private static final Block EXAMPLE_BLOCK = new ExampleBlock(FabricBlockSettings.create().strength(4.0f));
	private static final Item EXAMPLE_ITEM = new Item(new Item.Settings().maxCount(1));
	private static final Item WAND = new Wand(new Item.Settings().maxCount(1));
	public static final RegistryKey<DamageType> SPELL_DAMAGE = RegistryKey.of(DAMAGE_TYPE, new Identifier(MOD_ID, "spell_damage"));

	public static DamageSource of(World world, RegistryKey<DamageType> key) {
		return new DamageSource(world.getRegistryManager().get(DAMAGE_TYPE).entryOf(key));
	}
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(EXAMPLE_ITEM))
			.displayName(Text.translatable("itemGroup.lypheamod.test_group"))
			.entries((context, entries) -> {
				entries.add(EXAMPLE_ITEM);
				entries.add(WAND);
			})
			.build();


	public static ArrayList<TextRenderRequest.TextRequestToRender> TextRenderRequestQueue = new ArrayList<TextRenderRequest.TextRequestToRender>();
	@Override
	public void onInitializeClient() {
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "example_block"), EXAMPLE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "example_block"), EXAMPLE_ITEM);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "wand"), WAND);
		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "test_group"), ITEM_GROUP);

		ClientPlayConnectionEvents.JOIN.register(new PlayerJoinManaSync());
		EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.ARMADILO, ArmadiloRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ARMADILO, ArmadiloModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.DRAGON, DragonRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DRAGON, DragonModel::getTexturedModelData);
		KeyInputHandler.register();
		ModMessages.registerS2CPackets();
//		ClientTickEvents.
//		ServerPlayConnectionEvents.JOIN.register(new ServerPlayConnectionEvents.Join() {
//			@Override
//			public void onPlayReady(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server) {
//				ManaData.addMana((IEntityDataSaver) MinecraftClient.getInstance().player, 0);
//			}
//		});
	}
}
