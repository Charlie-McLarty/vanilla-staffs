package net.sycodonut.vanillastaffs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class VanillaStaffsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(VanillaStaffs.STAFF_PROJECTILE_ENTITY_TYPE, FlyingItemEntityRenderer::new);
    }
}
