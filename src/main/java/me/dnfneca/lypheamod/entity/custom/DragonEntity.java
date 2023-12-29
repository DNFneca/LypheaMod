package me.dnfneca.lypheamod.entity.custom;

import me.dnfneca.lypheamod.client.Color;
import me.dnfneca.lypheamod.entity.ModEntities;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DragonEntity extends AnimalEntity {

	public final AnimationState idleAnimationState = new AnimationState();
	private int idleAnimationTimeout = 0;

	private final int entityLevel = 15;

	private int stage = 1;

	private int transitionTime = 0;

	public DragonEntity(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}
	private void setupAnimationStates() {
		if (this.idleAnimationTimeout <= 0) {
			this.idleAnimationTimeout = this.random.nextInt(40) + 80;
			this.idleAnimationState.start(this.age);
		} else {
			--this.idleAnimationTimeout;
		}
	}

	@Override
	protected void updateLimbs(float posDelta) {
		float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
		this.limbAnimator.updateLimbs(f, 0.2f);
	}

	@Override
	public void playSpawnEffects() {
		if (this.getWorld().isClient) {
			for(int i = 0; i < 20; ++i) {
				double d = this.random.nextGaussian() * 0.02;
				double e = this.random.nextGaussian() * 0.02;
				double f = this.random.nextGaussian() * 0.02;
				double g = 10.0;
				this.getWorld().addParticle(ParticleTypes.LAVA, this.offsetX(1.0) - d * 10.0, this.getRandomBodyY() - e * 10.0, this.getParticleZ(1.0) - f * 10.0, d, e, f);
			}
		} else {
			this.getWorld().sendEntityStatus(this, (byte)20);
		}

	}

	@Override
	public void tick() {
		super.tick();
		if(this.getWorld().isClient()) {
			if(this.getHealth() != this.getMaxHealth()) {
				String name = Color.Color(Color.GRAY) + "[" + Color.Color(Color.BLUE) + "Lv" + this.entityLevel + Color.Color(Color.GRAY) + "]" + Color.Color(Color.WHITE) + " Porcupine " + Color.Color(Color.RED) + this.getHealth() + Color.Color(Color.GRAY) + "/" + Color.Color(Color.RED) + this.getMaxHealth() + Color.Color(Color.DARK_RED) + "♥";
				this.setCustomName(Text.of(name));
			}
//            this.getDataTracker().get(TrackedData)
			System.out.println(this.stage == 1 && this.getHealth() < this.getMaxHealth()*0.4 && this.transitionTime < 60);
			System.out.println(this.transitionTime);
			System.out.println(this.idleAnimationTimeout);

			if(this.stage == 1 && this.getHealth() < this.getMaxHealth()*0.4 && this.transitionTime < 60) {
				double d = this.random.nextGaussian() * 0.02;
				double e = this.random.nextGaussian() * 0.02;
				double f = this.random.nextGaussian() * 0.02;
				this.getWorld().addParticle(ParticleTypes.LAVA, this.offsetX(1.0) - d * 10.0, this.getRandomBodyY() + 1 - e * 10.0, this.getParticleZ(1.0) - f * 10.0, d, e, f);
				d = this.random.nextGaussian() * 0.02;
				e = this.random.nextGaussian() * 0.02;
				f = this.random.nextGaussian() * 0.02;
				this.getWorld().addParticle(ParticleTypes.LAVA, this.offsetX(1.0) - d * 10.0, this.getRandomBodyY() + 1 - e * 10.0, this.getParticleZ(1.0) - f * 10.0, d, e, f);
				this.setGlowing(true);
				this.setInvulnerable(true);
				this.speed = 0;
				this.transitionTime++;
			} else {
				this.setGlowing(true);
				this.speed = 1;
				this.setInvulnerable(false);
			}
			setupAnimationStates();
		}
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new SwimGoal(this));

		this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
		this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItems(Items.BEETROOT), false));

		this.goalSelector.add(3, new FollowParentGoal(this, 1.15D));

		this.goalSelector.add(4, new WanderAroundFarGoal(this, 1D));
		this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
		this.goalSelector.add(6, new LookAroundGoal(this));
	}

	public static DefaultAttributeContainer.Builder createDragonAttributes() {
		return MobEntity.createMobAttributes()
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
				.add(EntityAttributes.GENERIC_ARMOR, 0.5f)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.isOf(Items.BEETROOT);
	}

	@Nullable
	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return ModEntities.DRAGON.create(world);
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_FOX_AMBIENT;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_CAT_HURT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_DOLPHIN_DEATH;
	}
}
