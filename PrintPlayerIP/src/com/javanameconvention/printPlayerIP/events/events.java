package com.javanameconvention.printPlayerIP.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class events implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String ip = String.valueOf(Objects.requireNonNull(player.getAddress()).getAddress());
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[GetPlayerIP] The ip of " + player.getDisplayName() + " is " + ip);
    }
}
