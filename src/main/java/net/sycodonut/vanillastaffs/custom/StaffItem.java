package net.sycodonut.vanillastaffs.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class StaffItem extends Item {

    public StaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient && (hand == Hand.MAIN_HAND || hand == Hand.OFF_HAND)){
            PotionEntity potionEntity = new PotionEntity(world, user); //(EntityType<? extends PotionEntity> entityType, World world) from PotionEntity for choosing type
            potionEntity.setItem(itemStack);
            potionEntity.setVelocity(user, user.getPitch(), user.getYaw(), -20.0f, 0.5f, 1.0f);
            world.spawnEntity(potionEntity);
            //5 Second Cooldown
            user.getItemCooldownManager().set(this, 100);
        }

        return super.use(world, user, hand);
    }

//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        ItemStack itemStack = user.getStackInHand(hand);
//        if (!world.isClient && (hand == Hand.MAIN_HAND || hand == Hand.OFF_HAND)){
//            StaffProjectile staffProjectile = new StaffProjectile(world, user);
//            staffProjectile.setItem(itemStack);
//            staffProjectile.setVelocity(user, user.getPitch(), user.getYaw(), -20.0f, 0.5f, 1.0f);
//            world.spawnEntity(staffProjectile);
//            //5 Second Cooldown
//            user.getItemCooldownManager().set(this, 100);
//        }
//
//        return super.use(world, user, hand);
//    }
}
