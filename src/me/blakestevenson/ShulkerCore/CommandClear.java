package me.blakestevenson.ShulkerCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("shulkercore.clear")) {
                if(args.length == 1) {
                    Player otherPlayer = Bukkit.getServer().getPlayer(args[0]);
                    otherPlayer.getInventory().clear();
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "Cleared " + otherPlayer.getName() + "'s inventory.");
                    otherPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "Your inventory was cleared by " + sender.getName() + ".");
                } else if(args.length == 0) {
                    Player player = (Player) sender;
                    player.getInventory().clear();
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "Inventory Cleared!");
                } else {
                    sender.sendMessage(ChatColor.RED + "Syntax: /clear [player]");
                }
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
        }
        return true;
    }
}
