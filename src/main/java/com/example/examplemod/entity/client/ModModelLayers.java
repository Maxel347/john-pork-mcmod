package com.example.examplemod.entity.client;

import com.example.examplemod.maxmodcool;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation RHINO_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(maxmodcool.MOD_ID, "rhino_layer"), "main");
    public static final ModelLayerLocation PORKUS_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(maxmodcool.MOD_ID, "porkus_layer"), "main");
}
