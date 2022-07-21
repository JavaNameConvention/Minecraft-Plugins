package com.javanameconvention.playerWellness;

import com.javanameconvention.playerWellness.commands.commands;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    @Override
    public void onEnable() {
        commands commands = new commands();
        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Player Wellness] Plugin has loaded");
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Player Wellness] Plugin has stopped");
    }
}
