package io.github.animationlib.test;

import io.github.animationlib.AnimationLibary;
import io.github.animationlib.enums.Animation;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExampleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(strings.length == 1) {
                Player target = Bukkit.getPlayer(strings[0]);
                AnimationLibary.getAnimationLibary().playerAnimations.sendPublicAsyncPlayerAnimation(player, Animation.SWING_ARM);
            }
        }
        return false;
    }
}
