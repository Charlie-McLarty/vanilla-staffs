package net.sycodonut.vanillastaffs.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sycodonut.vanillastaffs.VanillaStaffs;


public class VanillaStaffsEnchantments {
    public static Enchantment CASTING = register("casting",
            new CastingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, EquipmentSlot.OFFHAND));

    private static Enchantment register(String name, Enchantment enchantment){
        return Registry.register(Registries.ENCHANTMENT, new Identifier(VanillaStaffs.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments(){
        System.out.println("Registering Enchantments for " + VanillaStaffs.MOD_ID);
    }
}
