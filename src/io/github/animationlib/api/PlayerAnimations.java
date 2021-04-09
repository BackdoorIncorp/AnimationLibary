package io.github.animationlib.api;

import io.github.animationlib.AnimationLibary;
import io.github.animationlib.enums.Animation;
import io.github.animationlib.utils.ReflectionHelper;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import net.minecraft.server.v1_16_R3.PacketPlayOutAnimation;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PlayerAnimations extends ReflectionHelper {

    public void sendPublicAsyncPlayerAnimation(Player player, Animation animation) {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        Bukkit.getScheduler().runTaskAsynchronously(AnimationLibary.getAnimationLibary(), new Runnable() {
            @Override
            public void run() {
                PacketPlayOutAnimation packetPlayOutAnimation = new PacketPlayOutAnimation();
                setValue(packetPlayOutAnimation, "a", entityPlayer.getId());
                setValue(packetPlayOutAnimation, "b", animation.i);
                sendPublicPacket(packetPlayOutAnimation);
            }
        });
    }

    public void sendPrivateAsyncPlayerAnimation(Player player, Animation animation) {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        Bukkit.getScheduler().runTaskAsynchronously(AnimationLibary.getAnimationLibary(), new Runnable() {
            @Override
            public void run() {
                PacketPlayOutAnimation packetPlayOutAnimation = new PacketPlayOutAnimation();
                setValue(packetPlayOutAnimation, "a", entityPlayer.getId());
                setValue(packetPlayOutAnimation, "b", animation.i);
                sendPacket(packetPlayOutAnimation, player);
            }
        });
    }

    public void sendPublicSyncPlayerAnimation(Player player, Animation animation) {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        Bukkit.getScheduler().runTask(AnimationLibary.getAnimationLibary(), new Runnable() {
            @Override
            public void run() {
                PacketPlayOutAnimation packetPlayOutAnimation = new PacketPlayOutAnimation();
                setValue(packetPlayOutAnimation, "a", entityPlayer.getId());
                setValue(packetPlayOutAnimation, "b", animation.i);
                sendPublicPacket(packetPlayOutAnimation);
            }
        });
    }

    public void sendPrivateSyncPlayerAnimation(Player player, Animation animation) {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        Bukkit.getScheduler().runTask(AnimationLibary.getAnimationLibary(), new Runnable() {
            @Override
            public void run() {
                PacketPlayOutAnimation packetPlayOutAnimation = new PacketPlayOutAnimation();
                setValue(packetPlayOutAnimation, "a", entityPlayer.getId());
                setValue(packetPlayOutAnimation, "b", animation.i);
                sendPacket(packetPlayOutAnimation, player);
            }
        });
    }

    public void sendPrivateAsyncPlayerAnimation(EntityPlayer player, Animation animation) {
        Bukkit.getScheduler().runTaskAsynchronously(AnimationLibary.getAnimationLibary(), new Runnable() {
            @Override
            public void run() {
                PacketPlayOutAnimation packetPlayOutAnimation = new PacketPlayOutAnimation();
                setValue(packetPlayOutAnimation, "a", player.getId());
                setValue(packetPlayOutAnimation, "b", animation.i);
                sendEntityPacket(packetPlayOutAnimation, player);
            }
        });
    }
    public void sendPrivateSyncPlayerAnimation(EntityPlayer player,Animation animation) {
        Bukkit.getScheduler().runTask(AnimationLibary.getAnimationLibary(), new Runnable() {
            @Override
            public void run() {
              PacketPlayOutAnimation packetPlayOutAnimation = new PacketPlayOutAnimation();
              setValue(packetPlayOutAnimation,"a",player.getId());
              setValue(packetPlayOutAnimation,"b",animation.i);
              sendEntityPacket(packetPlayOutAnimation,player);
            }
        });
    }
}



