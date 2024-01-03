package me.dnfneca.lypheamod.mixin;

import me.dnfneca.lypheamod.client.render.RenderHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static me.dnfneca.lypheamod.client.LypheaModClient.MOD_ID;

@Mixin(InGameHud.class)
public class HotbarMixin {

	private static final RenderHandler handler = new RenderHandler();

	@Inject(method = "render", at = @At(value = "HEAD"))
	public void renderHealthBar(DrawContext context, float tickDelta, CallbackInfo ci) {
		handler.render(context, tickDelta);
	}

	@Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHealthBar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/entity/player/PlayerEntity;IIIIFIIIZ)V"), method = "renderStatusBars")
	public void disableVanillaHealthBar(InGameHud instance, DrawContext context, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking) {
		// do nothing, vanilla health bar is not rendered anymore
	}

	@Redirect(at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(II)I"), method = "renderStatusBars")
	public int rowHeight(int a, int b) {
		// The height of a health bar is 10 at Math.max(10 - (q - 2), 3)
		// at Math.max(j, i) we want the renderer to think there is only one line of hearts, so we return 10
		return 10;
	}

	@Redirect(at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(FF)F"), method = "renderStatusBars")
	public float fakeHealth(float a, float b) {
		// The renderer should there is only one health row so the armor is displayed at the right place
		return 20;
	}

	@Inject(at = @At("HEAD"), method = "renderStatusBars", cancellable = true)
	private void renderStatusBars(DrawContext dc, CallbackInfo info) {
		info.cancel();
	}

	@Redirect(method = "renderStatusBars", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;getAbsorptionAmount()F"))
	public float fakeAbsorption(PlayerEntity player) {
		// The renderer should think there is only one absorption row if the player has absorption
		// so the armor is displayed at the right place
		return (player.getAbsorptionAmount() > 0) ? 20 : 0;
	}
}
