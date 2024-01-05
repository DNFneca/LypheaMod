package me.dnfneca.lypheamod.util;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Location {
	private double x;
	private double y;
	private double z;
	private double Yaw = 0;
	private double Pitch = 0;
	private World world;
	public Location(double x, double y, double z, double Yaw, double Pitch, World world) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.Yaw = Yaw;
		this.Pitch = Pitch;
		this.world = world;
	}

	public static Location getLocation(Entity entity) {
		return new Location(entity.getX(), entity.getY(), entity.getZ(), entity.getYaw(), entity.getPitch(), entity.getWorld());
	}

	public double getPitch() {
		return this.Pitch;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getYaw() {
		return this.Yaw;
	}

	public double getZ() {
		return this.z;
	}

	public World getWorld() {
		return this.world;
	}

	public String toString() {
		return new String("X:" + String.valueOf(this.x)
				+ ", Y:" + String.valueOf(this.y)
				+ ", Z:" + String.valueOf(this.z)
				+ ", Yaw:" + String.valueOf(this.Yaw)
				+ ", Pitch:" + String.valueOf(this.Pitch));
	}

	public double distanceBetween(Location location){
		return sqrt(pow(location.x - this.x, 2) + pow(location.y - this.y, 2) + pow(location.z - this.z, 2));
	}


}
