package me.dnfneca.lypheamod.abilities;

import me.dnfneca.lypheamod.abilities.baseabilities.HomingSpell;
import me.dnfneca.lypheamod.utilities.Location;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.ArrayList;

import static me.dnfneca.lypheamod.client.LypheaModClient.client;
import static me.dnfneca.lypheamod.utilities.Location.getLocation;

public class ManaDrain extends HomingSpell {
	ManaDrain(ServerPlayerEntity abilityThrower) {
		super(getLocation(abilityThrower), abilityThrower, new double[]{1, 1, 1}, 1, 2, false, 30);
		Location startLocation = getLocation(abilityThrower);
		this.smooth = true;
		this.x = startLocation.getX();
		this.y = startLocation.getY();
		this.z = startLocation.getZ();
		this.yaw = (float) (startLocation.getYaw() * (3.14f / 180.0f));
		this.pitch = (float) (startLocation.getPitch() * (3.14f / 180.0f));
		this.abilityThrower = abilityThrower;
		this.maxRotationAngle = 15;
		this.shouldHaveTrail = true;
		this.trailParticle = ParticleTypes.HEART;
		listOfSkillshots.add(this);
		client.player.sendMessage(Text.of(getLocation(abilityThrower).toString()));
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
