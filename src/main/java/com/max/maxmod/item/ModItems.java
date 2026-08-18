package com.max.maxmod.item;

import com.max.maxmod.entity.ModEntities;
import com.max.maxmod.maxmodcool;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, maxmodcool.MOD_ID);

    public static final RegistryObject<Item> TESTITEM = ITEMS.register("test_item",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JPORK_EGG =
            ITEMS.register("jpork_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.PORKUS,  0x8B4513, 0xFF69B4,
                            new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
