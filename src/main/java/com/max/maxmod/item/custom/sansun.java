package com.max.maxmod.item.custom;

import com.max.maxmod.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class sansun extends Item {
    public sansun(Properties properties) {
        super(properties);
    }

    public static boolean isAnimating = false;
    public static int animationTicks = 0;

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.playSound(ModSounds.SANSUN_S.get(), 1.0F, 1.0F);

        if (level.isClientSide()) {
            isAnimating = true;
            animationTicks = 2500; // 2.5 Sekunden
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }



}