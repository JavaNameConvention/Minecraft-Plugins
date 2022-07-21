package com.JavaNameConvention.plugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[CompassTracker] Plugin is Enabled!");
        getCommand("track").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[CompassTracker] Plugin is Disabled!");
    }
}
