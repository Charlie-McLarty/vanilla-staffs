package net.sycodonut.vanillastaffs;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.sycodonut.vanillastaffs.custom.StaffProjectile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaStaffs implements ModInitializer {
	public static final String MOD_ID = "vanillastaffs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		VanillaStaffItems.registerModItems();
		VanillaStaffsProjectiles.registerModProjectiles();
		EntityRendererRegistry.register(VanillaStaffsProjectiles.StaffProjectile, FlyingItemEntityRenderer::new);
	}
}
