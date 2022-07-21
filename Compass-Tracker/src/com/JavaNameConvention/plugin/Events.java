package com.JavaNameConvention.plugin;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.CompassMeta;

import java.util.List;

public class Events implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public static void interactWithCompass(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().getDisplayName().equals("Player Tracker") && event.getItem().getItemMeta().hasEnchant(Enchantment.BINDING_CURSE)) {
                    Player player = event.getPlayer();
                    List<String> lore = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                    String name = lore.get(1);
                    try {
                        Player toTrack = Bukkit.getPlayer(name);
                        Location track = toTrack.getLocation();
                        if (toTrack.getWorld().getEnvironment() != player.getWorld().getEnvironment()) {
                            player.sendMessage(ChatColor.GRAY + "This player is not in the same dimension as you!");
                            System.exit(0);
                        }
                        if (player.getWorld().getEnvironment().equals(World.Environment.NETHER) || player.getWorld().getEnvironment().equals(World.Environment.THE_END)) {
                            track.setY(0);
                            track.getBlock().setType(Material.LODESTONE);
                            CompassMeta meta = (CompassMeta) event.getItem().getItemMeta();
                            meta.setLodestone(track);
                            meta.setLodestoneTracked(true);
                            event.getItem().setItemMeta(meta);
                        } else {
                            player.setCompassTarget(track);
                        }
                        player.sendMessage(ChatColor.YELLOW + "Currently tracking: " + name);
                    } catch (Exception e) {
                        player.sendMessage(ChatColor.RED + "An error occurred! Player may be offline.");
                        Bukkit.getConsoleSender().sendMessage(String.valueOf(e));
                    }
                }
            }
        }
    }
}
