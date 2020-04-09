package me.blakestevenson.ShulkerCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHelp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(ChatColor.DARK_AQUA + "Help:\n" + ChatColor.RED + "/kit");
        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
