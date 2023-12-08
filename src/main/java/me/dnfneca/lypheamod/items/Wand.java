package me.dnfneca.lypheamod.items;

import me.dnfneca.lypheamod.entity.client.PorcupineRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import static me.dnfneca.lypheamod.client.LypheaModClient.MOD_ID;

public class Wand extends Item {
	public Wand(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (!world.isClient) {
			user.sendMessage(Text.literal("Hello, world!"), false);
		}



		PorcupineRenderer.TEXTURE = new Identifier(MOD_ID, "textures/entity/img.png");
		world.addParticle(ParticleTypes.HEART, user.getX(), user.getY() + 2.0, user.getZ(), 0.0, 0.0, 0.0);
//		user.getStackInHand(hand)
		return TypedActionResult.success(user.getStackInHand(hand), true);
	}
}
