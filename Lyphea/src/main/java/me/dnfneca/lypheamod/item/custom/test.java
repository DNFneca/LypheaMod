package me.dnfneca.lypheamod.item.custom;

import me.dnfneca.lypheamod.LypheaModClient;
import me.dnfneca.lypheamod.networking.ModMessages;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class test extends Item {

    public test(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()) {
            world.playSound(null, user.getBlockPos(), LypheaModClient.EQUIP_ROBE_1_EVENT, SoundCategory.BLOCKS, 1f, 1f);
            return super.use(world, user, hand);
        }
        user.sendMessage(Text.literal("Hello, world!"), true);

        user.getWorld().playSound(null, user.getBlockPos(), LypheaModClient.EQUIP_ROBE_1_EVENT, SoundCategory.MASTER, 1f, 1f);
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeString("TestAbility");
        ClientPlayNetworking.send(ModMessages.CAST_ABILITY_ID, buf);

//		world.addParticle(ParticleTypes.HEART, user.getX(), user.getY() + 2.0, user.getZ(), 0.0, 0.0, 0.0);
//		return super.use(world, user, hand);
        return TypedActionResult.success(user.getInventory().getMainHandStack());
    }
}
