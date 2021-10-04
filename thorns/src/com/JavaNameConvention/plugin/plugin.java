package com.JavaNameConvention.plugin;

import com.JavaNameConvention.plugin.listeners.listeners;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class plugin extends JavaPlugin{
   public void onEnable() {
       getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Thorns] Plugin is enabled");
       getServer().getPluginManager().registerEvents((Listener) new listeners(), this);

   }
   public void onDisable() {
       getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Thorns] Plugin is disabled");
   }
}
