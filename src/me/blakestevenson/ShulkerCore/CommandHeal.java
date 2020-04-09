package me.blakestevenson.ShulkerCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("shulkercore.heal")) {
        if(strings.length == 0) {
            Player player = (Player) commandSender;
            commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "You were healed.");
            player.setHealth(20.0);
            player.setFoodLevel(20);
            player.setFireTicks(0);
        } else if(strings.length == 1) {
            Player playerOne = Bukkit.getServer().getPlayer(strings[0]);
            if(playerOne != null) {
                playerOne.sendMessage(ChatColor.LIGHT_PURPLE + "You were healed by " + commandSender.getName() + ".");
                commandSender.sendMessage(ChatColor.LIGHT_PURPLE + playerOne.getName() + " was healed.");
                playerOne.setHealth(20.0);
                playerOne.setFoodLevel(20);
                playerOne.setFireTicks(0);
            } else {
                commandSender.sendMessage(ChatColor.RED + "Player not found.");
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "Syntax: /heal [player]");
        }
    } else {
        commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
    }
        return true;
    }
}
