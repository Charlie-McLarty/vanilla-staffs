package net.sycodonut.vanillastaffs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.sycodonut.vanillastaffs.projectile.VanillaStaffsProjectiles;

public class VanillaStaffsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(VanillaStaffsProjectiles.StaffProjectileEntityType, FlyingItemEntityRenderer::new);
    }
}
