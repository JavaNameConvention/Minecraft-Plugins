package com.JavaNameConvention.plugin;

import com.JavaNameConvention.plugin.commands.commands;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[HalfAHeart] Plugin is enabled");
        getCommand("halfaheart").setExecutor(new commands());
    }
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[HalfAHeart] Pluhin is disabled");
    }
}
