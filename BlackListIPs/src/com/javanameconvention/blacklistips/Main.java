package com.javanameconvention.blacklistips;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main extends JavaPlugin implements Listener {
    Queue<Player> queue = new LinkedList<>();
    ArrayList<String> blacklisted_ips = new ArrayList<>();
    @Override
    public void onEnable() {
        try {
            fileChecks();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getServer().getConsoleSender().sendMessage(String.valueOf(blacklisted_ips));

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[BlackListIPs] Plugin is enabled!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[BlackListIPs] Plugin is disabled.");
    }
    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent e) {
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "New PlayerLoginEvent");
        boolean kickPlayer = false;
        Player player = e.getPlayer();
        String hostname = e.getHostname().toLowerCase();
        getServer().getConsoleSender().sendMessage("Player: " + player.getDisplayName() + " Hostname: " + hostname);
        for (String x : blacklisted_ips) {
            x = x.toLowerCase();
            if (hostname.contains(x)) {
                getServer().getConsoleSender().sendMessage("This player has joined with direct IP");
                queue.add(player);
            }
        }
    }
    @EventHandler
    public void onPlayerLoadedIn(PlayerJoinEvent e) {
        getServer().getConsoleSender().sendMessage("Player loaded in");
        if (queue.isEmpty()) {
            return;
        }
        Player player = queue.poll();
        player.kickPlayer(ChatColor.RED + "You are not allowed to join this server using its direct ip, please use the assigned hostname.");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Player has been kicked for hostname");
    }
    public void fileChecks() throws IOException {
        File pluginFolder = new File(this.getDataFolder().toURI());
        if (!pluginFolder.exists()) {
            pluginFolder.mkdirs();
        }
        File txtFile = new File(this.getDataFolder(), "blacklist-ips.txt");
        if (!txtFile.exists()) {
            txtFile.createNewFile();
        }
        Scanner io = new Scanner(new FileReader(txtFile));
        while (io.hasNextLine()) {
            blacklisted_ips.add(io.nextLine().replace(".", "-"));
        }
    }
}

