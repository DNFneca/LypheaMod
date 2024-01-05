package me.dnfneca.lypheamod.abilities.baseabilities;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Ability {
    public static ArrayList<Ability> listOfAbilities = new ArrayList<>();
    public static ArrayList<Ability> abilitiesTrash = new ArrayList<>();
    float damage;
    String cost;
    boolean isDone = false;
    @NonNls String name;
    int abilityWindupTime = 0;
    Ability(String name, String cost, float damage) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
    }

    public void tick() {
        if(this.isDone) abilitiesTrash.add(this);
    }

    public String getCost() {
        return this.cost;
    }

    public float getDamage() {
        return this.damage;
    }

    public static @Nullable Ability getAbilityByName(String name) {
        for (Ability ability : listOfAbilities) {
            if (ability.name.equals(name)) {
                return ability;
            }
        }
        return null;
    }
}
