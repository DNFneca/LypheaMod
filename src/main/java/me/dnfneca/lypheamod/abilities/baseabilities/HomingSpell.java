package me.dnfneca.lypheamod.abilities.baseabilities;

import me.dnfneca.lypheamod.utilities.Location;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

import static me.dnfneca.lypheamod.client.LypheaModClient.client;
import static me.dnfneca.lypheamod.utilities.Location.getLocation;
import static org.apache.commons.lang3.math.NumberUtils.toFloat;

public class HomingSpell extends Skillshot {

	/**
	 * supposed to be in degrees
	 */
	protected float maxRotationAngle;
	protected Location targetLocation;
	protected boolean smooth;
	public HomingSpell(Location location, Entity abilityThrower, double[] hitbox, float damage, double speed, boolean canHitPlayer, double range) {
		super(location, abilityThrower, hitbox, damage, speed, canHitPlayer, range);
	}

	protected @Nullable Location findClosestTarget(Location location, double radiusSearch) {
		World world = location.getWorld();
		List<LivingEntity> entityList = world.getEntitiesByType(TypeFilter.instanceOf(LivingEntity.class), new Box(location.getX(), location.getY(), location.getZ(), location.getX(), location.getY(), location.getZ()).expand(radiusSearch), (apply) -> {
			if ((apply.getType() == EntityType.PLAYER && !this.canHitPlayer) || apply.equals(this.abilityThrower)) return false;
			return true;
		});
		LivingEntity foundEntity = world.getClosestEntity(entityList, TargetPredicate.DEFAULT, null, location.getX(), location.getY(), location.getZ());
		if(null == foundEntity) return null;
		return getLocation(foundEntity);
	}
	protected boolean isTargetClose(Location location, double radiusSearch) {
		@Nullable Location closestTarget = this.findClosestTarget(location, radiusSearch);
		if(closestTarget != null) return true;
		return false;
	}

	private void rotateToTargetWithRestraints(Location targetLocation) {
		double deltaX = targetLocation.getX() - this.x;
		double deltaY = targetLocation.getY() - this.y;
		double deltaZ = targetLocation.getZ() - this.z;
		double horizontalDistance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
		float correctionYaw = (float) Math.atan2(-deltaX, deltaZ);
		float correctionPitch = (float) MathHelper.atan2(-deltaY, horizontalDistance);

		float maxRotationValueRad = (float) Math.toRadians(this.maxRotationAngle);
		float differenceBetweenAngles = this.yaw - correctionYaw;

		client.player.sendMessage(Text.of(String.valueOf(this.yaw)));


		//TODO map both to 360 and check the difference if greater than maxRotationValueRad then cap theta


		if(differenceBetweenAngles > maxRotationValueRad) {
			correctionYaw = this.yaw + maxRotationValueRad;
		} else if (differenceBetweenAngles < -maxRotationValueRad) {
			correctionYaw = this.yaw - maxRotationValueRad;
		}


//		correctionYaw = (float) Math.toRadians(MathHelper.wrapDegrees(Math.toDegrees(correctionYaw)));



//		correctionYaw = (float) Math.toRadians(MathHelper.wrapDegrees(Math.toDegrees(correctionYaw)));

//		if(differenceBetweenAngles < 0 && differenceBetweenAngles > -maxRotationValueRad) {
//			client.player.sendMessage(Text.of(String.valueOf(this.yaw + " " + maxRotationValueRad + " " + differenceBetweenAngles)));
//			correctionYaw = this.yaw;
//		} else if (differenceBetweenAngles > 0 && differenceBetweenAngles > maxRotationValueRad) {
//			client.player.sendMessage(Text.of(String.valueOf(this.yaw + " " + maxRotationValueRad)));
//			correctionYaw = this.yaw - maxRotationValueRad;
//		}

		this.yaw = correctionYaw;
		this.pitch = correctionPitch;
	}

	private void rotateToTargetNoRestraints(Location targetLocation) {
		double deltaX = targetLocation.getX() - this.x;
		double deltaY = targetLocation.getY() - this.y;
		double deltaZ = targetLocation.getZ() - this.z;
		double horizontalDistance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
		float correctionYaw = (float) Math.atan2(-deltaX, deltaZ);
		float correctionPitch = (float) Math.atan2(-deltaY, horizontalDistance);

		this.yaw = correctionYaw;
		this.pitch = correctionPitch;
	}

	@Override
	public void tick() {
		this.checkForRange();
		this.hitDetection();
		this.adjustRotation();
		if(this.shouldHaveTrail) client.player.getWorld().addParticle(trailParticle, true, this.x, this.y + 1, this.z, 0, 0, 0);
		this.move();
	}

	public void adjustRotation() {
		Location abilityLocation = new Location(this.x, this.y, this.z, this.yaw, this.pitch, this.abilityThrower.getWorld());
		if(isTargetClose(abilityLocation, this.range)) {
			Location targetLocation = this.findClosestTarget(abilityLocation, this.range);
			this.targetLocation = targetLocation;
		}
		if(null != this.targetLocation) {
			if(this.smooth) {
				this.rotateToTargetWithRestraints(this.targetLocation);
			} else {
				this.rotateToTargetNoRestraints(this.targetLocation);
			}
		}
	}

	@Override
	public void move() {
		this.x -= MathHelper.sin(this.yaw) * MathHelper.cos(this.pitch) * this.speed;
		this.y -= MathHelper.sin(this.pitch) * this.speed;
		this.z += MathHelper.cos(this.yaw) * MathHelper.cos(this.pitch) * this.speed;
	}
}
