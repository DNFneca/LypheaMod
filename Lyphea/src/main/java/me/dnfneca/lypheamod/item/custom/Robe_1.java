package me.dnfneca.lypheamod.item.custom;

import me.dnfneca.lypheamod.LypheaModClient;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

import java.util.stream.Stream;

public class Robe_1 implements ArmorMaterial  {

    @Override
    public int getDurability(ArmorItem.Type type) {
        return 33;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return LypheaModClient.EQUIP_ROBE_1_EVENT;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofStacks((Stream<ItemStack>) Items.STRING);
    }

    @Override
    public String getName() {
        return "lypheamod:ruby";
    }

    @Override
    public float getToughness() {
        return 3;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1F;
    }
}
