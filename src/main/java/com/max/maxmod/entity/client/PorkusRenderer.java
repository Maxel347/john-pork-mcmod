package com.max.maxmod.entity.client;

import com.max.maxmod.entity.costom.PorkusEntity;
import com.max.maxmod.maxmodcool;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PorkusRenderer extends MobRenderer<PorkusEntity, PorkusModel<PorkusEntity>> {

    public PorkusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PorkusModel<>(pContext.bakeLayer(ModModelLayers.PORKUS_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(PorkusEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(maxmodcool.MOD_ID, "textures/entity/porkus.png");
    }

    @Override
    protected void setupRotations(PorkusEntity pEntityLiving, PoseStack pMatrixStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
        super.setupRotations(pEntityLiving, pMatrixStack, pAgeInTicks, pRotationYaw, pPartialTicks);

        PorkusModel<PorkusEntity> model = this.getModel();

        float earWobble = net.minecraft.util.Mth.sin(pAgeInTicks * 0.1f) * 0.2f;

        model.right_ear.zRot = earWobble;
        model.left_ear.zRot = -earWobble;
    }
}