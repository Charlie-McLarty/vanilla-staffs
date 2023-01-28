package net.sycodonut.vanillastaffs;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.sycodonut.vanillastaffs.custom.StaffItem;
import net.minecraft.registry.Registry;

public class VanillaStaffItems {
    public static final Item staff = registerItem("staff", new StaffItem(new FabricItemSettings().maxCount(1).maxDamage(16).rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(VanillaStaffs.MOD_ID, name), item);
    }

    public static void registerModItems(){
        VanillaStaffs.LOGGER.debug("Registering mod items for " + VanillaStaffs.MOD_ID);
    }
}
