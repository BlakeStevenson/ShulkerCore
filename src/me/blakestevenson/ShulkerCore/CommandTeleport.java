package me.blakestevenson.ShulkerCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class CommandTeleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("shulkercore.teleport")) {
        try {
            switch (strings.length) {
                case (1): // to player
                    Player player = (Player) commandSender;
                    Player toPlayer = getServer().getPlayer(strings[0]);
                    if (toPlayer != null) {
                        player.teleport(toPlayer.getLocation());
                        commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Teleporting to " + strings[0]);
                    } else commandSender.sendMessage(ChatColor.RED + "Player not found");
                    break;
                case (2): // player to player
                    Player playerOne = getServer().getPlayer(strings[0]);
                    Player playerTwo = getServer().getPlayer(strings[1]);
                    if (playerOne != null && playerTwo != null) {
                        playerOne.teleport(playerTwo.getLocation());
                        commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Teleporting " + strings[0] + " to " + strings[1]);

                    } else commandSender.sendMessage(ChatColor.RED + "Player not found.");
                    break;
                case (3): // to coordinates
                    Player sender = (Player) commandSender;
                    Double[] coords = {Double.parseDouble(strings[0]), Double.parseDouble(strings[1]), Double.parseDouble(strings[2])};
                    sender.teleport(new Location(sender.getWorld(), coords[0], coords[1], coords[2]));
                    commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Teleporting to " + strings[0] + ", " + strings[1] + ", " + strings[2] + "...");
                    break;
                case (4): // to coordinates in world
                    World world = getServer().getWorld(strings[3]);
                    if(world != null) {
                        Player worldSender = (Player) commandSender;
                        Double[] worldCoords = {Double.parseDouble(strings[0]), Double.parseDouble(strings[1]), Double.parseDouble(strings[2])};
                        worldSender.teleport(new Location(world, worldCoords[0], worldCoords[1], worldCoords[2]));
                        commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "Teleporting to " + strings[0] + ", " + strings[1] + ", " + strings[2] + " in " + strings[3] + "...");
                    } else commandSender.sendMessage(ChatColor.RED + "Invalid World");
                    break;
                default:
                    commandSender.sendMessage(ChatColor.RED + "Usage: /tp <player>\n /tp <player 1> <player 2>\n /tp <x> <y> <z> [world]");
            }
            return true;
        } catch(Exception e) {
            commandSender.sendMessage(ChatColor.RED + "Usage: /tp <player>\n /tp <player 1> <player 2>\n /tp <x> <y> <z> [world]");
            return false;
        }
        } else {
            commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
        }
        return true;
    }
}
