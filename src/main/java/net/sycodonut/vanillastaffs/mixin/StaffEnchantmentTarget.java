package net.sycodonut.vanillastaffs.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.sycodonut.vanillastaffs.enchantment.CastingEnchantment;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public abstract class StaffEnchantmentTarget {
    //may remove
//    @Shadow
//    @Final
//    public EnchantmentTarget type;
//    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
//    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
//        Enchantment enchantment = (Enchantment) (Object) this;
//        if (enchantment instanceof CastingEnchantment) {
//
//            cir.setReturnValue(true);
//        }
//    }
}
