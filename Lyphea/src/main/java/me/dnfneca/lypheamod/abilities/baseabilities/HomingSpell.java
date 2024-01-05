package me.dnfneca.lypheamod.abilities.baseabilities;

import me.dnfneca.lypheamod.util.Location;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static java.lang.Math.*;
import static me.dnfneca.lypheamod.LypheaModClient.client;
import static me.dnfneca.lypheamod.util.Location.getLocation;
import static me.dnfneca.lypheamod.util.Rotation.normalizeAngle;

public class HomingSpell extends Skillshot {

	/**
	 * supposed to be in degrees
	 */
	protected float maxRotationAngle;
	private Location targetLocation;
	protected boolean smooth;

	/**
	 * @param location the location of the player that threw the ability
	 * @param abilityThrower the entity (usually a player) that threw the ability
	 * @param hitbox the hitbox of the ability as a double list which size is 3
	 * @param damage the amount of damage supposed to be dealt to the enemy hit (defences apply onm hit)
	 * @param speed the speed at which the ability travels (blocks/tick) (tick = second/20)
	 * @param cost the mana cost of the ability (is a string, can be abs(amount) and similar equations)
	 * @param range the range of the ability
	 */
	public HomingSpell(Location location, Entity abilityThrower, double[] hitbox, float damage, double speed, String cost, double range, String name) {
		super(location, abilityThrower, hitbox, damage, speed, cost, range, name);
	}

	@Nullable
    private Location findClosestTarget(Location location, double radiusSearch) {
		World world = location.getWorld();
		List<LivingEntity> entityList = world.getEntitiesByType(TypeFilter.instanceOf(LivingEntity.class), new Box(location.getX(), location.getY(), location.getZ(), location.getX(), location.getY(), location.getZ()).expand(radiusSearch), (apply) -> (apply.getType() != EntityType.PLAYER || this.canHitPlayer) && !apply.equals(this.abilityThrower));
		LivingEntity foundEntity = world.getClosestEntity(entityList, TargetPredicate.DEFAULT, null, location.getX(), location.getY(), location.getZ());
		if(null == foundEntity) return null;
		return getLocation(foundEntity);
	}
	private boolean isTargetClose(Location location, double radiusSearch) {
		@Nullable Location closestTarget = this.findClosestTarget(location, radiusSearch);
        return closestTarget != null;
    }


	private void rotateToTargetWithRestraints(Location targetLocation) {
		double deltaX = targetLocation.getX() - this.x;
		double deltaY = targetLocation.getY() - this.y;
		double deltaZ = targetLocation.getZ() - this.z;
		double horizontalDistance = sqrt(deltaX * deltaX + deltaZ * deltaZ);
		float correctionYaw = (float) toRadians(normalizeAngle((float) toDegrees(StrictMath.atan2(-deltaX, deltaZ))));
		this.yaw = (float) toRadians(normalizeAngle((float) toDegrees(this.yaw)));
		float correctionPitch = (float) StrictMath.atan2(-deltaY, horizontalDistance);

		float maxRotationValueRad = (float) toRadians(this.maxRotationAngle);
		float differenceBetweenAngles = abs(correctionYaw - this.yaw);

		float direction = this.chooseDirection(this.yaw, correctionYaw);
		if(direction == 1 && differenceBetweenAngles > maxRotationValueRad) {
			this.yaw = this.yaw + maxRotationValueRad;
		} else if (direction == -1 && differenceBetweenAngles > maxRotationValueRad) {
			this.yaw = this.yaw - maxRotationValueRad;
		} else {
			this.yaw = correctionYaw;
		}

		this.pitch = correctionPitch;
	}

	private void rotateToTargetNoRestraints(Location targetLocation) {
		double deltaX = targetLocation.getX() - this.x;
		double deltaY = targetLocation.getY() - this.y;
		double deltaZ = targetLocation.getZ() - this.z;
		double horizontalDistance = sqrt(deltaX * deltaX + deltaZ * deltaZ);
		float correctionYaw = (float) atan2(-deltaX, deltaZ);
		float correctionPitch = (float) atan2(-deltaY, horizontalDistance);

		this.yaw = correctionYaw;
		this.pitch = correctionPitch;
	}

	@Override
	public void tick() {
		this.checkForRange();
		this.hitDetection();
		this.adjustRotation();
		if(this.shouldHaveTrail) client.player.getWorld().addParticle(this.trailParticle, true, this.x, this.y + 1, this.z, 0, 0, 0);
		this.move();
	}

	private void adjustRotation() {
		Location abilityLocation = new Location(this.x, this.y, this.z, this.yaw, this.pitch, this.abilityThrower.getWorld());
		if(this.isTargetClose(abilityLocation, this.range)) {
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

	private float chooseDirection(float currentYaw, float optimalYaw) {
//		client.player.sendMessage(Text.of(String.valueOf(diff)));

		float difference = (float) (toDegrees(optimalYaw) - toDegrees(currentYaw));

		if(difference < -180.0f)
			difference += 360.0f;
		if(difference > 180.0f)
			difference -= 360.0f;

		if(difference > 0.0f)
			return 1;
		if(difference < 0.0f)
			return -1;

		return 0;


//		float diff360 = (float) (2 * PI-diff);
//		float result = min(diff, diff360);
//
//		float delta_theta = 0;
//		if(optimalYaw > currentYaw) {
//			delta_theta = (float) (2*PI - currentYaw - optimalYaw);
//			if(delta_theta > maxRotationAngle) {
//				return currentYaw - maxRotationAngle;
//			} else {
//				return optimalYaw;
//			}
//		}
//		else {
//			delta_theta = currentYaw - optimalYaw;
//			if(delta_theta > maxRotationAngle) {
//				return currentYaw + maxRotationAngle;
//			} else {
//				return optimalYaw;
//			}
//		}
	}


}
