package me.blakestevenson.ShulkerCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("shulkercore.gamemode")) {
        if (strings.length > 0) {
            Player player;
            if (strings.length == 2) {
                player = Bukkit.getServer().getPlayer(strings[1]);
                if (player != null) {
                    CommandGamemode.switchGamemode(strings[0], player, commandSender);
                } else {
                    commandSender.sendMessage(ChatColor.RED + "Invalid Player.");
                }
            } else {
                player = (Player) commandSender;
                CommandGamemode.switchGamemode(strings[0], player, commandSender);
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "Syntax: /gamemode <mode> [player]");
        }
    } else {
        commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
    }
        return true;
    }


        public static void switchGamemode(String mode, Player player, CommandSender commandSender) {
            switch (mode) {
                case "s":
                case "0":
                case "survival":
                    player.setGameMode(GameMode.SURVIVAL);
                    commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Gamemode successfully updated");
                    break;
                case "c":
                case "1":
                case "creative":
                    player.setGameMode(GameMode.CREATIVE);
                    commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Gamemode successfully updated");
                    break;
                case "a":
                case "2":
                case "adventure":
                    player.setGameMode(GameMode.ADVENTURE);
                    commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Gamemode successfully updated");
                    break;
                case "sp":
                case "3":
                case "spectator":
                    player.setGameMode(GameMode.SPECTATOR);
                    commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Gamemode successfully updated");
                    break;
            }
        }
    }
