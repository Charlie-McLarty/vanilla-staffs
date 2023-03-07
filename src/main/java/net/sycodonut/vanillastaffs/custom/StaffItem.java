package net.sycodonut.vanillastaffs.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.LingeringPotionItem;
import net.minecraft.potion.PotionUtil;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.sycodonut.vanillastaffs.projectile.StaffProjectile;

public class StaffItem extends Item {

    public StaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient && (hand == Hand.MAIN_HAND || hand == Hand.OFF_HAND)){

            if (this instanceof FrostStaffItem){
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
                user.getItemCooldownManager().set(this, 5);
                StaffProjectile staffProjectileEntity = new StaffProjectile(world, user);
                    staffProjectileEntity.setItem(itemStack);
                    staffProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
                    world.spawnEntity(staffProjectileEntity);
                    user.incrementStat(Stats.USED.getOrCreateStat(this));

                return TypedActionResult.success(itemStack, world.isClient());
            }
            PotionEntity potionEntity = new PotionEntity(world, user);
            potionEntity.setItem(itemStack);
            potionEntity.setVelocity(user, user.getPitch(), user.getYaw(), -20.0f, 0.5f, 1.0f);
            world.spawnEntity(potionEntity);
            //5 Second Cooldown
            user.getItemCooldownManager().set(this, 100);
        }

        return super.use(world, user, hand);
    }
}
