package me.blakestevenson.ShulkerCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("shulkercore.fly")) {
        Player player = (Player) commandSender;
        if(player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.setFlying(false);
            commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Flight disabled.");
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
            commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Flight enabled.");
        }
    } else {
        commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
    }
        return true;
    }
}
