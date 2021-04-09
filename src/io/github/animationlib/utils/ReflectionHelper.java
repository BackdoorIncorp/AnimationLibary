package io.github.animationlib.utils;

import net.minecraft.server.v1_16_R3.EntityPlayer;
import net.minecraft.server.v1_16_R3.Packet;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class ReflectionHelper {

    public void setValue(Object obj,String name,Object value)  {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public Object getValue(Object obj,String name)  {
        Field field = null;
        try {
            field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendPacket(Packet obj, Player player) {
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(obj);
    }
    public void sendPublicPacket(Packet obj) {
        Bukkit.getOnlinePlayers().stream().forEach(player -> {
            sendPacket(obj,player);
        });
    }
    public void sendEntityPacket(Packet obj, EntityPlayer entityPlayer) {
        entityPlayer.playerConnection.sendPacket(obj);
    }


}
