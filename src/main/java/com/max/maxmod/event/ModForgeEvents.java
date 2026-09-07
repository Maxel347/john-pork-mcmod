package com.max.maxmod.event;

import com.max.maxmod.item.ModItems;
import com.max.maxmod.item.custom.sansun;
import com.max.maxmod.maxmodcool;
import com.max.maxmod.sound.ModSounds;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = maxmodcool.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModForgeEvents {

    @SubscribeEvent
    public static void onRenderGui(RenderGuiOverlayEvent.Post event) {
        if (!sansun.isAnimating) return;

        sansun.animationTicks--;
        if (sansun.animationTicks <= 0) {
            sansun.isAnimating = false;
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        int screenWidth = event.getWindow().getGuiScaledWidth();
        int screenHeight = event.getWindow().getGuiScaledHeight();

        PoseStack poseStack = event.getGuiGraphics().pose();
        poseStack.pushPose();
        poseStack.translate(screenWidth / 2.0, screenHeight / 2.0, 0);
        poseStack.scale(4.0F, 4.0F, 4.0F);

        event.getGuiGraphics().renderItem(
                mc.player.getMainHandItem(),
                -8, -8
        );

        poseStack.popPose();
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        // Nur auf Server-Seite und nur jede 20 Ticks prüfen
        if (!player.level().isClientSide() && player.tickCount % 200 == 0) {

            // Prüfen ob das Item im Inventar ist
            if (player.getInventory().contains(new ItemStack(ModItems.SANSUN.get()))) {

                // %pro Sekunde
                if (player.level().random.nextFloat() < 0.000005f) {
                    player.playSound(ModSounds.SANSUN_S.get(), 1.0F, 1.0F);

                    //Client auslösen
                    if (player instanceof ServerPlayer serverPlayer) {
                        // Broadcast an Client
                        player.level().broadcastEntityEvent(player, (byte) 35);
                    }

                    sansun.isAnimating = true;
                    sansun.animationTicks = 100;
                }
            }
        }
    }
}