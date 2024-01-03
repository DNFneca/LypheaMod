package me.dnfneca.lypheamod.items;

import me.dnfneca.lypheamod.networking.ModMessages;
import me.dnfneca.lypheamod.utilities.IEntityDataSaver;
import me.dnfneca.lypheamod.utilities.ManaData;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Wand extends Item {
	public Wand(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if(!world.isClient()) {
			return super.use(world, user, hand);
		}
		if (!world.isClient) {
			user.sendMessage(Text.literal("Hello, world!"), false);
		}
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeString("manaDrain");
		ClientPlayNetworking.send(ModMessages.CAST_ABILITY_ID, buf);

//		world.addParticle(ParticleTypes.HEART, user.getX(), user.getY() + 2.0, user.getZ(), 0.0, 0.0, 0.0);
//		return super.use(world, user, hand);
		return TypedActionResult.success(user.getInventory().getMainHandStack());
	}
}
