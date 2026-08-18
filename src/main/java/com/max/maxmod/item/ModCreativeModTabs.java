package com.max.maxmod.item;

import com.max.maxmod.maxmodcool;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, maxmodcool.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JOHNPORK_TAB = CREATIVE_MODE_TABS.register("johnpork",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.TESTITEM.get()))
                    .title(Component.translatable("creativetab.johnpork_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TESTITEM.get());
                        pOutput.accept(ModItems.JPORK_EGG.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
