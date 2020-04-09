package me.blakestevenson.ShulkerCore;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        //Fired when the server enables the plugin
        System.out.println("Loading ShulkerCore");
        //this.getCommand("help").setExecutor(new CommandHelp());
        this.getCommand("kit").setExecutor(new CommandKit());
        this.getCommand("ci").setExecutor(new CommandClear());
        this.getCommand("msg").setExecutor(new CommandMessage());
        this.getCommand("tp").setExecutor(new CommandTeleport());
        this.getCommand("gamemode").setExecutor(new CommandGamemode());
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("speed").setExecutor(new CommandSpeed());
        this.getCommand("heal").setExecutor(new CommandHeal());
        this.getCommand("feed").setExecutor(new CommandFeed());
    }
    @Override
    public void onDisable() {
        //Fired when the server enables the plugin
        System.out.println("Unloading ShulkerCore");
    }
}
