package net.sycodonut.vanillastaffs;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sycodonut.vanillastaffs.custom.StaffProjectile;

public class VanillaStaffsProjectiles {
    public static final EntityType<StaffProjectile> StaffProjectile = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(VanillaStaffs.MOD_ID, "staff_projectile"),
            FabricEntityTypeBuilder.<StaffProjectile>create(SpawnGroup.MISC, StaffProjectile::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static void registerModProjectiles(){
        VanillaStaffs.LOGGER.debug("Registering mod items for " + VanillaStaffs.MOD_ID);
    }
}
