package net.sycodonut.vanillastaffs.client;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.sycodonut.vanillastaffs.projectile.StaffProjectile;

public class StaffProjectileEntityRenderer extends EntityRenderer<StaffProjectile> {
    protected StaffProjectileEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(StaffProjectile entity) {
        return null;
    }
}
