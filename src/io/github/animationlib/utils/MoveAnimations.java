package io.github.animationlib.utils;

import io.github.animationlib.AnimationLibary;
import io.github.animationlib.enums.MoveAnimationType;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class MoveAnimations {

    public void playAnimation(ArmorStand armorStand, MoveAnimationType moveAnimationType,int animationtime) {
        final int[] time = {animationtime};
        switch (moveAnimationType){

            case KILL_ANIMATION:
                Bukkit.getScheduler().scheduleSyncRepeatingTask(AnimationLibary.getAnimationLibary(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(time[0] != 0) {
                            Bukkit.getScheduler().runTaskAsynchronously(AnimationLibary.getAnimationLibary(), new Runnable() {
                                @Override
                                public void run() {
                                    armorStand.eject();
                                }
                            });
                        }else {
                            time[0]--;
                            armorStand.getLocation().add(0,0.1,0);
                        }

                    }
                },1,1);
            case GO_UP:
                Bukkit.getScheduler().scheduleSyncRepeatingTask(AnimationLibary.getAnimationLibary(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(time[0] != 0) {
                            Bukkit.getScheduler().runTaskAsynchronously(AnimationLibary.getAnimationLibary(), new Runnable() {
                                @Override
                                public void run() {
                                    armorStand.eject();
                                }
                            });
                        }else {
                            time[0]--;
                            armorStand.getLocation().add(0,0.1,0);
                        }

                    }
                },1,1);

            case GO_DOWN:
                Bukkit.getScheduler().scheduleSyncRepeatingTask(AnimationLibary.getAnimationLibary(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(time[0] != 0) {
                            Bukkit.getScheduler().runTaskAsynchronously(AnimationLibary.getAnimationLibary(), new Runnable() {
                                @Override
                                public void run() {
                                    armorStand.eject();
                                }
                            });
                        }else {
                            time[0]--;
                            armorStand.getLocation().add(0,-0.1,0);
                        }

                    }
                },1,1);
            case SIDE_TO_SIDE:
                Bukkit.getScheduler().scheduleSyncRepeatingTask(AnimationLibary.getAnimationLibary(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(time[0] != 0) {
                            Bukkit.getScheduler().runTaskAsynchronously(AnimationLibary.getAnimationLibary(), new Runnable() {
                                @Override
                                public void run() {
                                    armorStand.eject();
                                }
                            });
                        }else {
                            time[0]--;
                            armorStand.getLocation().add(0.1,0,0);
                        }

                    }
                },1,1);
            case LEFT_TO_RIGHT:
                Bukkit.getScheduler().scheduleSyncRepeatingTask(AnimationLibary.getAnimationLibary(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(time[0] != 0) {
                            Bukkit.getScheduler().runTaskAsynchronously(AnimationLibary.getAnimationLibary(), new Runnable() {
                                @Override
                                public void run() {
                                    armorStand.eject();
                                }
                            });
                        }else {
                            time[0]--;
                            armorStand.getLocation().add(-0.1,0,0);
                        }

                    }
                },1,1);
            case RIGHT_TO_LEFT:
                Bukkit.getScheduler().scheduleSyncRepeatingTask(AnimationLibary.getAnimationLibary(), new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(time[0] != 0) {
                            Bukkit.getScheduler().runTaskAsynchronously(AnimationLibary.getAnimationLibary(), new Runnable() {
                                @Override
                                public void run() {
                                    armorStand.eject();
                                }
                            });
                        }else {
                            time[0]--;
                            armorStand.getLocation().add(0.1,0,0);
                        }

                    }
                },1,1);

        }

    }

}
