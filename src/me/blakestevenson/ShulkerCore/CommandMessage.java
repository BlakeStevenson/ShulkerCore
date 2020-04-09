package me.blakestevenson.ShulkerCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class CommandMessage implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender.hasPermission("shulkercore.message")) {
        try {
            StringBuilder message = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                message.append(" ").append(args[i]);
            }
            Player toPlayer = getServer().getPlayer(args[0]);
            assert toPlayer != null;
            toPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "From " + commandSender.getName() + ":" + ChatColor.GREEN + message);
            commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "To " + toPlayer.getName() + ":" + ChatColor.GREEN + message);
            return true;
        } catch(Exception e) {
            commandSender.sendMessage(ChatColor.RED + "Usage: /msg <username> <message>");
            return false;
        }
    } else {
        commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
    }
        return true;
        }
}
