package me.dnfneca.lypheamod.abilities.baseabilities;

import me.dnfneca.lypheamod.client.LypheaModClient;
import me.dnfneca.lypheamod.utilities.Location;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;

import java.util.ArrayList;

import static me.dnfneca.lypheamod.client.LypheaModClient.SPELL_DAMAGE;
import static me.dnfneca.lypheamod.client.LypheaModClient.client;
import static me.dnfneca.lypheamod.utilities.Location.getLocation;

public class Skillshot {
	public static ArrayList<Skillshot> listOfSkillshots = new ArrayList<Skillshot>();

	public static ArrayList<Skillshot> skillshotTrash = new ArrayList<>();

	protected double x;
	protected double y;
	protected double z;
	protected double hitboxX = 0.2;
	protected double hitboxY = 0.2;
	protected double hitboxZ = 0.2;

	protected float yaw;
	protected float prevYaw;
	protected float pitch;
	protected float prevPitch;
	protected Entity abilityThrower;
	protected boolean canHitPlayer;
	private final float damage;

	protected double range;

	protected boolean shouldHaveTrail = false;

	protected ParticleEffect trailParticle = ParticleTypes.LARGE_SMOKE;
	/**
	 *
	 * Is described in blocks/tick
	 *
	 */
	double speed;

	Skillshot(Location location, Entity abilityThrower, double[] hitbox, float damage, double speed, boolean canHitPlayer, double range) {
		this.x = location.getX();
		this.y = location.getY();
		this.z = location.getZ();
		if(3 == hitbox.length) {
			this.hitboxX = hitbox[0];
			this.hitboxY = hitbox[0];
			this.hitboxZ = hitbox[0];
		}
		this.yaw = (float) location.getYaw();
		this.prevYaw = (float) location.getYaw();
		this.pitch = (float) location.getPitch();
		this.prevPitch = (float) location.getPitch();
		this.abilityThrower = abilityThrower;
		this.damage = damage;
		this.speed = speed;
		this.canHitPlayer = canHitPlayer;
		this.range = range;
	}

	public void tick() {
		this.checkForRange();
		this.hitDetection();
		if(this.shouldHaveTrail) client.player.getWorld().addParticle(trailParticle, true, this.x, this.y + 1, this.z, 0, 0, 0);
		this.move();
	}

	public void hitDetection() {
		LivingEntity foundEntity = this.abilityThrower.getWorld().getClosestEntity(LivingEntity.class, TargetPredicate.DEFAULT, null, this.x, this.y, this.z, new Box(this.x, this.y, this.z, this.x, this.y, this.z).expand(this.hitboxX, this.hitboxY, this.hitboxZ));
		if(null != foundEntity) {
			if(foundEntity.getType() == EntityType.PLAYER && this.canHitPlayer) {
				if(foundEntity.equals(this.abilityThrower)) {
					return;
				}
				this.hit(foundEntity);
				return;
			}
			if(foundEntity.getType() == EntityType.PLAYER && !this.canHitPlayer) {
				return;
			}
			this.hit(foundEntity);
		}
	}

	public void checkForRange() {
		Location abilityLocation = new Location(this.x, this.y, this.z, this.yaw, this.pitch, this.abilityThrower.getWorld());
		if(abilityLocation.distanceBetween(getLocation(this.abilityThrower)) > this.range) this.remove();
	}

	public void remove() {
		skillshotTrash.add(this);
	}

	public void hit(Entity entity) {
		entity.damage(LypheaModClient.of(entity.getWorld(), SPELL_DAMAGE), this.damage);
		this.abilityThrower.getWorld().addParticle(ParticleTypes.LARGE_SMOKE, true, this.x, this.y + 1, this.z, 0, 0, 0);
		this.remove();
	}

	public void move() {
		this.x -= MathHelper.sin(this.yaw) * MathHelper.cos(this.pitch) * this.speed;
		this.y -= MathHelper.sin(this.pitch) * this.speed;
		this.z += MathHelper.cos(this.yaw) * MathHelper.cos(this.pitch) * this.speed;
	}
}
