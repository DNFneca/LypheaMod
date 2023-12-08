package me.dnfneca.lypheamod.entity;

import me.dnfneca.lypheamod.entity.custom.ArmadiloEntity;
import me.dnfneca.lypheamod.entity.custom.DragonEntity;
import me.dnfneca.lypheamod.entity.custom.PorcupineEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static me.dnfneca.lypheamod.client.LypheaModClient.MOD_ID;

public class ModEntities {
    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "porcupine"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new)
                    .dimensions(EntityDimensions.changing(1f, 1f)).build());

    public static final EntityType<ArmadiloEntity> ARMADILO = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "armadilo"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ArmadiloEntity::new)
                    .dimensions(EntityDimensions.changing(1f, 1f)).build());

    public static final EntityType<DragonEntity> DRAGON = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DragonEntity::new)
                    .dimensions(EntityDimensions.changing(1f, 1f)).build());

}
