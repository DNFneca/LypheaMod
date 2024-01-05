package me.dnfneca.lypheamod.networking.packet;

import me.dnfneca.lypheamod.abilities.AbilityManager;
import me.dnfneca.lypheamod.util.IEntityDataSaver;
import me.dnfneca.lypheamod.util.ManaData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public class ManaC2SPacket {
    private static final String MESSAGE_DRINKING_WATER = "message.lypheamod.drank_water";
    private static final String MESSAGE_NO_WATER_NEARBY = "message.lypheamod.no_water";

    public static void sync(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                            PacketByteBuf buf, PacketSender responseSender) {
        double mana = ((IEntityDataSaver) player).getPersistentData().getDouble("mana");
        ManaData.syncMana(mana, player);
    }

    public static void add(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        // Everything here happens ONLY on the Server!
        ServerWorld world = (ServerWorld) player.getWorld();
        double mana = ((IEntityDataSaver) player).getPersistentData().getDouble("mana");
//        if(isAroundWaterThem(player, world, 2)) {
            // Notify the player

        player.sendMessage(Text.translatable(MESSAGE_DRINKING_WATER)

                .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)), false);

        int addedMana = buf.readInt();

        // Play the drinking sound

        world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,

                0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        // actually add the water level to the player

        ManaData.addMana(((IEntityDataSaver) player), addedMana);


//            MinecraftClient client = MinecraftClient.getInstance();

//            int width = client.getWindow().getScaledWidth();
//            int height = client.getWindow().getScaledHeight();

//            int x = width / 2;
//            int y = height;


//            new TextRenderRequest("+1", x - 94, y - 54, 200);
//        } else {
            // Notify the player
//            player.sendMessage(Text.translatable(MESSAGE_NO_WATER_NEARBY)
//                    .fillStyle(Style.EMPTY.withColor(Formatting.RED)), false);
//
//            // outputting the current thirst level of player
////            player.sendMessage(Text.literal("Thirst: " + mana)
////                    .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), true);
//
//            // Sync thirst
//            ManaData.syncMana(mana, player);
//        }
    }

    public static void remove(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                           PacketByteBuf buf, PacketSender responseSender) {
        // Everything here happens ONLY on the Server!
        ServerWorld world = (ServerWorld) player.getWorld();
        double mana = ((IEntityDataSaver) player).getPersistentData().getDouble("mana");
//        if(isAroundWaterThem(player, world, 2)) {
            // Notify the player
            player.sendMessage(Text.translatable(MESSAGE_DRINKING_WATER)
                    .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)), false);

            // Play the drinking sound
            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,
                    0.5F, world.random.nextFloat() * 0.1F + 0.9F);

            // actually add the water level to the player
            ManaData.removeMana(((IEntityDataSaver) player), 1);


//            MinecraftClient client = MinecraftClient.getInstance();
//
//            int width = client.getWindow().getScaledWidth();
//            int height = client.getWindow().getScaledHeight();
//
//            int x = width / 2;
//            int y = height;
//
//
//            new TextRenderRequest(String.valueOf(ManaData.getMana((IEntityDataSaver) player)), x - 94, y - 54, 200);
//        } else {
            // Notify the player
            player.sendMessage(Text.translatable(MESSAGE_NO_WATER_NEARBY)
                    .fillStyle(Style.EMPTY.withColor(Formatting.RED)), false);

            // outputting the current thirst level of player
//            player.sendMessage(Text.literal("Thirst: " + mana)
//                    .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), true);

            // Sync thirst
            ManaData.syncMana(mana, player);
//        }
    }

    public static void castability(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                              PacketByteBuf buf, PacketSender responseSender) {
        // Everything here happens ONLY on the Server!
        ServerWorld world = (ServerWorld) player.getWorld();

//        if(isAroundWaterThem(player, world, 2)) {
            // Notify the player
            player.sendMessage(Text.translatable(MESSAGE_DRINKING_WATER)
                    .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)), false);

            // Play the drinking sound
//            world.playSound(null, player.getBlockPos(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS,
//                    0.5F, world.random.nextFloat() * 0.1F + 0.9F);

            // actually add the water level to the player
//            ManaData.removeMana(((IEntityDataSaver) player), 1);

            String request = buf.readString();

            AbilityManager.tryToCast(player, request);


//            int width = client.getWindow().getScaledWidth();
//            int height = client.getWindow().getScaledHeight();
//
//            int x = width / 2;
//            int y = height;
//
//
//            new TextRenderRequest(String.valueOf(ManaData.getMana((IEntityDataSaver) player)), x - 94, y - 54, 200);
//        } else {
            // Notify the player
//            player.sendMessage(Text.translatable(MESSAGE_NO_WATER_NEARBY)
//                    .fillStyle(Style.EMPTY.withColor(Formatting.RED)), false);

            // outputting the current thirst level of player
//            player.sendMessage(Text.literal("Thirst: " + mana)
//                    .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), true);

            // Sync thirst
//            ManaData.syncMana(mana, player);
//        }
    }
//    private static boolean isAroundWaterThem(ServerPlayerEntity player, ServerWorld world, int size) {
//        return BlockPos.stream(player.getBoundingBox().expand(size))
//                .map(world::getBlockState).filter(state -> state.isOf(Blocks.WATER)).toArray().length > 0;
//    }
}
