package net.sycodonut.vanillastaffs.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.sycodonut.vanillastaffs.VanillaStaffItems;
import net.sycodonut.vanillastaffs.VanillaStaffsProjectiles;

public class StaffProjectile extends ThrownItemEntity {
    public StaffProjectile(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public StaffProjectile(World world, LivingEntity owner) {
        super(VanillaStaffsProjectiles.StaffProjectile, owner, world);
    }

    public StaffProjectile(World world, double x, double y, double z) {
        super(VanillaStaffsProjectiles.StaffProjectile, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return VanillaStaffItems.staff;
    }

    @Environment(EnvType.CLIENT)
    private ParticleEffect getParticleParameters() { // unknown purpose
        ItemStack itemStack = this.getItem();
        return (ParticleEffect)(itemStack.isEmpty() ? ParticleTypes.GLOW_SQUID_INK : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack));
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) { // unknown purpose
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            this.kill(); // kills the projectile
        }

    }
}
