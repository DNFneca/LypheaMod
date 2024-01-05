package me.dnfneca.lypheamod.util;

import net.minecraft.nbt.NbtCompound;

public interface IEntityDataSaver {
	NbtCompound getPersistentData();
}