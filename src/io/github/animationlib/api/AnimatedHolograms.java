package io.github.animationlib.api;

import com.google.common.base.Preconditions;
import io.github.animationlib.AnimationLibary;
import io.github.animationlib.api.exceptions.LocationNotObtainableException;
import io.github.animationlib.api.exceptions.TooManyLocationsProvidedException;
import io.github.animationlib.enums.MoveAnimationType;
import io.github.animationlib.utils.MoveAnimations;
import net.minecraft.server.v1_16_R3.EntityArmorStand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class AnimatedHolograms extends MoveAnimations {

    private String text;
    private Map<Integer,String> lines = new HashMap<>();
    private int linecount = 0;
    private Player player;
    private Location location;
    private boolean useGravity = false;
    private MoveAnimationType moveAnimations;

    public AnimatedHolograms(String text, @Nullable Player player,@Nullable Location location) throws TooManyLocationsProvidedException, LocationNotObtainableException {
        if(player == null && location == null) {
                throw new LocationNotObtainableException("The Location isnt obtainable");
        }else if(location == null){
            Preconditions.checkNotNull(player,new LocationNotObtainableException("The Player Location is null"));
            this.text = text;
            this.lines.put(linecount,text);
            linecount++;
            this.location = player.getLocation();
        }else if(player == null) {
            Preconditions.checkNotNull(location,new LocationNotObtainableException("The Location is null"));
            this.text = text;
            this.lines.put(linecount,text);
            linecount++;
            this.location = location;
        }else {
            throw new TooManyLocationsProvidedException("You can only use one Location per Hologram");
        }

    }
    public void addLine(String text) {
        lines.put(linecount,text);
        linecount++;
    }
    public void setUseGravity(boolean value) {
        this.useGravity = value;
    }
    public boolean getUseGravity() {
        return this.useGravity;
    }
    public int getCurrentLineCount() {
        return linecount;
    }
    public String getSpecificLine(int line) {
        return lines.get(line);
    }
    public Map getAllLines(){
        return lines;
    }
    public void setMoveAnimation(MoveAnimationType moveAnimations) {
        this.moveAnimations = moveAnimations;
    }
    public MoveAnimationType getMoveAnimation() {
        return this.moveAnimations;
    }
    public void start(int animationtime) {
        Bukkit.getScheduler().runTaskAsynchronously(AnimationLibary.getAnimationLibary(), new Runnable() {
            @Override
            public void run() {
                if (player == null) {
                    for (int i = 0; i > linecount; i++) {
                        ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
                        armorStand.setCustomName(lines.get(i));
                        armorStand.setVisible(false);
                        armorStand.setGravity(false);
                        armorStand.setCustomNameVisible(true);
                        playAnimation(armorStand, moveAnimations, animationtime);
                        location.add(0, 1, 0);
                    }
                }else {
                    for (int i = 0; i > linecount; i++) {
                        Location pLoc = player.getLocation();
                        ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(pLoc, EntityType.ARMOR_STAND);
                        armorStand.setCustomName(lines.get(i));
                        armorStand.setVisible(false);
                        armorStand.setGravity(false);
                        armorStand.setCustomNameVisible(true);
                        playAnimation(armorStand, moveAnimations, animationtime);
                        pLoc.add(0, 1, 0);
                    }
                }
            }
        });
    }
}
