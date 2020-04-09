package me.blakestevenson.ShulkerCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("shulkercore.speed")) {
        Player player = (Player) commandSender;
        if(strings.length == 1) {
            if (Float.parseFloat(strings[0]) <= 10.0) {
                if (!player.isOnGround()) {
                    player.setFlySpeed(Float.parseFloat(strings[0]) / 10);
                    commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Flight speed set to " + strings[0]);
                } else {
                    player.setWalkSpeed(Float.parseFloat(strings[0]) / 10);
                    commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Walk speed set to " + strings[0]);
                }
            } else {
                commandSender.sendMessage(ChatColor.RED + "Please use a value between 1 and 10.");
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "Syntax: /speed <value>");
        }
    } else {
        commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
    }
        return true;
    }
}
