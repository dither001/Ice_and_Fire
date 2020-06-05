package com.github.alexthe666.iceandfire.entity;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.init.Effects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityPixieCharge extends AbstractFireballEntity {

    public int ticksInAir;
    private float[] rgb;

    public EntityPixieCharge(World worldIn) {
        super(worldIn);
        rgb = EntityPixie.PARTICLE_RGB[rand.nextInt(EntityPixie.PARTICLE_RGB.length - 1)];
        this.setSize(0.5F, 0.5F);
    }

    public EntityPixieCharge(World worldIn, double posX, double posY, double posZ, double accelX, double accelY, double accelZ) {
        super(worldIn, posX, posY, posZ, accelX, accelY, accelZ);
        double d0 = (double) MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
        this.accelerationX = accelX / d0 * 0.07D;
        this.accelerationY = accelY / d0 * 0.07D;
        this.accelerationZ = accelZ / d0 * 0.07D;
        rgb = EntityPixie.PARTICLE_RGB[rand.nextInt(EntityPixie.PARTICLE_RGB.length - 1)];
        this.setSize(1.5F, 1.5F);
    }

    public EntityPixieCharge(World worldIn, PlayerEntity shooter, double accelX, double accelY, double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
        double d0 = (double) MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
        this.accelerationX = accelX / d0 * 0.07D;
        this.accelerationY = accelY / d0 * 0.07D;
        this.accelerationZ = accelZ / d0 * 0.07D;
        rgb = EntityPixie.PARTICLE_RGB[rand.nextInt(EntityPixie.PARTICLE_RGB.length - 1)];
        this.setSize(1.5F, 1.5F);
    }

    protected boolean isFireballFiery() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    public void onUpdate() {
        if (this.world.isRemote) {
            for (int i = 0; i < 5; ++i) {
                IceAndFire.PROXY.spawnParticle("if_pixie", this.getPosX() + this.rand.nextDouble() * 0.15F * (this.rand.nextBoolean() ? -1 : 1), this.getPosY() + this.rand.nextDouble() * 0.15F * (this.rand.nextBoolean() ? -1 : 1), this.getPosZ() + this.rand.nextDouble() * 0.15F * (this.rand.nextBoolean() ? -1 : 1), rgb[0], rgb[1], rgb[2]);
            }
        }
        if (this.world.isRemote || (this.shootingEntity == null || !this.shootingEntity.isDead) && this.world.isBlockLoaded(new BlockPos(this))) {
            super.onEntityUpdate();
            ++this.ticksInAir;
            RayTraceResult raytraceresult = ProjectileHelper.forwardsRaycast(this, true, this.ticksInAir >= 25, this.shootingEntity);
            if (raytraceresult != null && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
                this.onImpact(raytraceresult);
            }
            this.getPosX() += this.motionX;
            this.getPosY() += this.motionY;
            this.getPosZ() += this.motionZ;
            ProjectileHelper.rotateTowardsMovement(this, 0.2F);
            float f = this.getMotionFactor();
            this.motionX += this.accelerationX;
            this.motionY += this.accelerationY;
            this.motionZ += this.accelerationZ;
            this.motionX *= (double) f;
            this.motionY *= (double) f;
            this.motionZ *= (double) f;
            this.setPosition(this.getPosX(), this.getPosY(), this.getPosZ());
        } else {
            this.setDead();
        }
    }

    @Override
    protected void onImpact(RayTraceResult movingObject) {
        if (!this.world.isRemote) {
            if (movingObject.entityHit instanceof LivingEntity) {
                ((LivingEntity) movingObject.entityHit).addPotionEffect(new EffectInstance(Effects.LEVITATION, 100, 0));
                ((LivingEntity) movingObject.entityHit).addPotionEffect(new EffectInstance(Effects.GLOWING, 100, 0));
                movingObject.entityHit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(shootingEntity, null), 5.0F);
            }
            if (this.world.isRemote) {
                for (int i = 0; i < 20; ++i) {
                    IceAndFire.PROXY.spawnParticle("if_pixie", this.getPosX() + this.rand.nextDouble() * 1F * (this.rand.nextBoolean() ? -1 : 1), this.getPosY() + this.rand.nextDouble() * 1F * (this.rand.nextBoolean() ? -1 : 1), this.getPosZ() + this.rand.nextDouble() * 1F * (this.rand.nextBoolean() ? -1 : 1), rgb[0], rgb[1], rgb[2]);
                }
            }
            if (this.shootingEntity == null || !(shootingEntity instanceof PlayerEntity) || !((PlayerEntity) shootingEntity).isCreative()) {
                if (rand.nextInt(3) == 0) {
                    this.entityDropItem(new ItemStack(IafItemRegistry.PIXIE_DUST, 1), 0.45F);
                }
            }
        }
        this.setDead();
    }


    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    public float getCollisionBorderSize() {
        return 0F;
    }

}