package me.dnfneca.lypheamod;

import me.dnfneca.lypheamod.block.ModBlocks;
import me.dnfneca.lypheamod.block.entity.ModBlockEntities;
import me.dnfneca.lypheamod.block.entity.renderer.GemPolishingBlockEntityRenderer;
import me.dnfneca.lypheamod.entity.ModBoats;
import me.dnfneca.lypheamod.entity.ModEntities;
import me.dnfneca.lypheamod.entity.client.ModModelLayers;
import me.dnfneca.lypheamod.entity.client.PorcupineModel;
import me.dnfneca.lypheamod.entity.client.PorcupineRenderer;
import me.dnfneca.lypheamod.event.KeyInputHandler;
import me.dnfneca.lypheamod.item.custom.Robe_1;
import me.dnfneca.lypheamod.networking.ModMessages;
import me.dnfneca.lypheamod.screen.GemPolishingScreen;
import me.dnfneca.lypheamod.screen.ModScreenHandlers;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import me.dnfneca.lypheamod.util.TextRenderRequest;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;

import static me.dnfneca.lypheamod.LypheaMod.MOD_ID;
import static net.minecraft.registry.RegistryKeys.DAMAGE_TYPE;

public class LypheaModClient implements ClientModInitializer {

    public static ArrayList<TextRenderRequest.TextRequestToRender> TextRenderRequestQueue = new ArrayList<>();

    public static final MinecraftClient client = MinecraftClient.getInstance();
//    private static final Item WAND = new Wand(new Item.Settings().maxCount(1));
//    private static final Item TEST = new test(new Item.Settings().maxCount(1));


    //

    public static final Identifier EQUIP_ROBE_1 = new Identifier("lypheamod:equip_robe_1");
    public static SoundEvent EQUIP_ROBE_1_EVENT = SoundEvent.of(EQUIP_ROBE_1);
    public static final RegistryKey<DamageType> SPELL_DAMAGE = RegistryKey.of(DAMAGE_TYPE, new Identifier(MOD_ID, "spell_damage"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(DAMAGE_TYPE).entryOf(key));
    }
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAHLIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_DAHLIA, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHESTNUT_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHESTNUT_SAPLING, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);

        HandledScreens.register(ModScreenHandlers.GEM_POLISHING_SCREEN_HANDLER, GemPolishingScreen::new);

        BlockEntityRendererFactories.register(ModBlockEntities.GEM_POLISHING_STATION_BLOCK_ENTITY, GemPolishingBlockEntityRenderer::new);

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CHESTNUT_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CHESTNUT_HANGING_SIGN_TEXTURE));

        TerraformBoatClientHelper.registerModelLayers(ModBoats.CHESTNUT_BOAT_ID, false);

        EntityRendererRegistry.register(ModEntities.DICE_PROJECTILE, FlyingItemEntityRenderer::new);

        KeyInputHandler.register();
        ModMessages.registerS2CPackets();
    }
}
