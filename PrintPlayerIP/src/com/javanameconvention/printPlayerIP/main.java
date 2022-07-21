package com.javanameconvention.printPlayerIP;

import com.javanameconvention.printPlayerIP.events.events;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new events(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[GetPlayerIP] Plugin has loaded");
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[GetPlayerIP] Plugin has stopped");
    }
}
