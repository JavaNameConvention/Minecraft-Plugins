package com.JavaNameConvention.plugin.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class listeners implements Listener {
    @EventHandler
    public static void onPlayerHitMob(EntityDamageByEntityEvent event) {

        Player player = (Player) event.getDamager();
        double health = player.getHealth();
        Entity damager = event.getDamager();

        if (damager == player) {
            player.setHealth((int) (health - 1));
        }


    }
}
