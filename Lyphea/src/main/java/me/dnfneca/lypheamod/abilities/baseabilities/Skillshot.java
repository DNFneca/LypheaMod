package me.dnfneca.lypheamod.abilities.baseabilities;

import me.dnfneca.lypheamod.LypheaModClient;
import me.dnfneca.lypheamod.util.Location;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;

import static me.dnfneca.lypheamod.LypheaModClient.SPELL_DAMAGE;
import static me.dnfneca.lypheamod.LypheaModClient.client;
import static me.dnfneca.lypheamod.util.Location.getLocation;

public class Skillshot extends Ability {

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
	protected double range;

	protected boolean shouldHaveTrail = false;
	/**
	 * is described in ticks
	 */
	protected int skillshotWindupTime = 0;

	protected ParticleEffect trailParticle = null;
	/**
	 * Is described in blocks/tick
	 */
	double speed;

	Skillshot(Location location, Entity abilityThrower, double[] hitbox, float damage, double speed, String cost, double range, String name) {
        super(name, cost, damage);
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        if (3 == hitbox.length) {
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
        this.range = range;
        this.cost = cost;
    }

	@Override
	public void tick() {
		this.checkForRange();
		this.hitDetection();
		if(this.shouldHaveTrail) client.player.getWorld().addParticle(trailParticle, true, this.x, this.y + 1, this.z, 0, 0, 0);
		this.move();
	}

	void hitDetection() {
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

	void checkForRange() {
		Location abilityLocation = new Location(this.x, this.y, this.z, this.yaw, this.pitch, this.abilityThrower.getWorld());
		if(abilityLocation.distanceBetween(getLocation(this.abilityThrower)) > this.range) this.remove();
	}

	private void remove() {
		abilitiesTrash.add(this);
	}

	private void hit(Entity entity) {
		entity.damage(LypheaModClient.of(entity.getWorld(), SPELL_DAMAGE), this.damage);
		this.abilityThrower.getWorld().addParticle(ParticleTypes.LARGE_SMOKE, true, this.x, this.y + 1, this.z, 0, 0, 0);
		this.remove();
	}

	void move() {
		this.x -= MathHelper.sin(this.yaw) * MathHelper.cos(this.pitch) * this.speed;
		this.y -= MathHelper.sin(this.pitch) * this.speed;
		this.z += MathHelper.cos(this.yaw) * MathHelper.cos(this.pitch) * this.speed;
	}
}
