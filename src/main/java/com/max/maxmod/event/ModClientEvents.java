package com.max.maxmod.event;

import com.max.maxmod.entity.ModEntities;
import com.max.maxmod.entity.client.*;
import com.max.maxmod.maxmodcool;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = maxmodcool.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.RHINO.get(), RhinoRenderer::new);
        event.registerEntityRenderer(ModEntities.PORKUS.get(), PorkusRenderer::new);
    }


    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RHINO_LAYER, RhinoModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.PORKUS_LAYER, PorkusModel::createBodyLayer);

    }


}