package me.dnfneca.lypheamod.entity;

import me.dnfneca.lypheamod.LypheaMod;
import me.dnfneca.lypheamod.block.ModBlocks;
import me.dnfneca.lypheamod.item.ModItems;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier CHESTNUT_BOAT_ID = new Identifier(LypheaMod.MOD_ID, "chestnut_boat");
    public static final Identifier CHESTNUT_CHEST_BOAT_ID = new Identifier(LypheaMod.MOD_ID, "chestnut_chest_boat");

    public static final RegistryKey<TerraformBoatType> CHESTNUT_BOAT_KEY = TerraformBoatTypeRegistry.createKey(CHESTNUT_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType chestnutBoat = new TerraformBoatType.Builder()
                .item(ModItems.CHESTNUT_BOAT)
                .chestItem(ModItems.CHESTNUT_CHEST_BOAT)
                .planks(ModBlocks.CHESTNUT_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, CHESTNUT_BOAT_KEY, chestnutBoat);
    }
}
