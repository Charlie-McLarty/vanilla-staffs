package net.sycodonut.vanillastaffs.projectile;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sycodonut.vanillastaffs.VanillaStaffs;

public class VanillaStaffsProjectiles {
    public static final EntityType<StaffProjectile> StaffProjectileEntityType = register("staff_projectile");

    private static EntityType<StaffProjectile> register(String name){
        return Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(VanillaStaffs.MOD_ID, name),
                FabricEntityTypeBuilder.<StaffProjectile>create(SpawnGroup.MISC, StaffProjectile::new)
                        .dimensions(EntityDimensions.fixed(.25F, .25F)) //.25F
                        .trackRangeBlocks(4).trackedUpdateRate(10)
                        .build()
        );
    }

    public static void registerModProjectiles(){
        System.out.println("Registering Projectiles for " + VanillaStaffs.MOD_ID);
    }
}
