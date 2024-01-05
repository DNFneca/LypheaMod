package me.dnfneca.lypheamod.abilities;

import me.dnfneca.lypheamod.abilities.baseabilities.Ability;
import me.dnfneca.lypheamod.abilities.baseabilities.HomingSpell;
import me.dnfneca.lypheamod.util.Location;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;

import static me.dnfneca.lypheamod.util.Location.getLocation;

public class ManaDrain extends HomingSpell {
	ManaDrain(ServerPlayerEntity abilityThrower) {
		super(getLocation(abilityThrower), abilityThrower, new double[]{1, 1, 1}, 1, 2, "abs(10)", 30, "ManaDrain");
		Location startLocation = getLocation(abilityThrower);
		this.skillshotWindupTime = 15;
		this.smooth = true;
		this.x = startLocation.getX();
		this.y = startLocation.getY();
		this.z = startLocation.getZ();
		this.yaw = (float) (Math.toRadians(startLocation.getYaw()));
		this.pitch = (float) (Math.toRadians(startLocation.getPitch()));
		this.abilityThrower = abilityThrower;
		this.maxRotationAngle = 10;
		this.shouldHaveTrail = true;
		this.trailParticle = ParticleTypes.HEART;
		Ability.listOfAbilities.add(this);
	}



//	@Override
//	public void tick() {
//		this.hitDetection();
//		client.player.getWorld().addParticle(ParticleTypes.HEART, true, this.x, this.y + 1, this.z, 0, 0, 0);
//		Location abilityLocation = new Location(this.x, this.y, this.z, this.yaw, this.pitch, this.abilityThrower.getWorld());
//		if(isTargetClose(abilityLocation, 10)) {
//			Location targetLocation = findClosestTarget(abilityLocation, 10);
//
//			this.targetLocation = targetLocation;
//		}
//		this.move();
//	}

}
