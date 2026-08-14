package com.example.examplemod.entity.client;

import com.example.examplemod.entity.costom.PorkusEntity;
import com.example.examplemod.entity.costom.RhinoEntity;
import com.example.examplemod.maxmodcool;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PorkusRenderer extends MobRenderer<RhinoEntity, RhinoModel<RhinoEntity>> {
    public PorkusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RhinoModel<>(pContext.bakeLayer(ModModelLayers.PORKUS_LAYER)), 2f);
    }




    @Override
    public ResourceLocation getTextureLocation(RhinoEntity rhinoEntity) {
        return ResourceLocation.fromNamespaceAndPath(maxmodcool.MOD_ID, "textures/entity/rhino.png");

    }
}

