package io.github.animationlib;

import io.github.animationlib.api.PlayerAnimations;
import io.github.animationlib.utils.ReflectionHelper;
import org.bukkit.plugin.java.JavaPlugin;

public class AnimationLibary extends JavaPlugin {

    private static AnimationLibary animationLibary;
    public PlayerAnimations playerAnimations = new PlayerAnimations();
    public ReflectionHelper reflectionHelper = new ReflectionHelper();
    @Override
    public void onEnable() {
        animationLibary = this;

    }

    @Override
    public void onDisable() {


    }

    public static AnimationLibary getAnimationLibary() {
        return animationLibary;
    }

    public PlayerAnimations getPlayerAnimations() {
        return playerAnimations;
    }

    public ReflectionHelper getReflectionHelper() {
        return reflectionHelper;
    }
}
