package com.max.maxmod.entity;

import com.max.maxmod.entity.costom.PorkusEntity;
import com.max.maxmod.entity.costom.RhinoEntity;
import com.max.maxmod.maxmodcool;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, maxmodcool.MOD_ID);

    public static final RegistryObject<EntityType<RhinoEntity>> RHINO =
            ENTITY_TYPES.register("rhino", () -> EntityType.Builder.of(RhinoEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("rhino"));

    public static final RegistryObject<EntityType<PorkusEntity>> PORKUS =
            ENTITY_TYPES.register("porkus", () -> EntityType.Builder.of(PorkusEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.8f).build("porkus"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}