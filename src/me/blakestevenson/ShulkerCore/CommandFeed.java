package me.blakestevenson.ShulkerCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("shulkercore.feed")) {
        if(strings.length == 0) {
            Player player = (Player) commandSender;
            commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "You were fed.");
            player.setFoodLevel(20);
        } else if(strings.length == 1) {
            Player playerOne = Bukkit.getServer().getPlayer(strings[0]);
            if(playerOne != null) {
                playerOne.sendMessage(ChatColor.LIGHT_PURPLE + "You were fed by " + commandSender.getName() + ".");
                commandSender.sendMessage(ChatColor.LIGHT_PURPLE + playerOne.getName() + " was fed.");
                playerOne.setFoodLevel(20);
            } else {
                commandSender.sendMessage(ChatColor.RED + "Player not found.");
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "Syntax: /feed [player]");
        }
    } else {
        commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
    }
        return true;
    }
}
