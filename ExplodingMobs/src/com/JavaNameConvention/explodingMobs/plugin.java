package com.JavaNameConvention.explodingMobs;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class plugin extends JavaPlugin implements Listener {
    public void onEnable() {

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ExplodingMobs] Plugin is enabled");
        getServer().getPluginManager().registerEvents(this, this);

    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[ExplodingMobs] Plugin is disabled");

    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        String configPath = "mobs." + entity.getType().getName();
        boolean isPlayerSpawnedExplosiveMob = entity.hasMetadata("isPlayerSpawnedExplosiveMob");
        if (entity.getKiller() == null && !isPlayerSpawnedExplosiveMob && !getConfig().getBoolean(configPath + ".triggeredByAny", getConfig().getBoolean("defaults.triggeredByAny")))
            return;
        if (isPlayerSpawnedExplosiveMob || getConfig().getBoolean(configPath + ".enabled", getConfig().getBoolean("defaults.enabled"))) {
            Location entityLocation = entity.getLocation();
            double x = entityLocation.getX();
            double y = entityLocation.getY();
            double z = entityLocation.getZ();
            float power = (float) getConfig().getDouble(configPath + ".power", getConfig().getDouble("defaults.power"));
            boolean setFire = getConfig().getBoolean(configPath + ".setFire", getConfig().getBoolean("defaults.setFire"));
            boolean breakBlocks = getConfig().getBoolean(configPath + ".breakBlocks", getConfig().getBoolean("defaults.breakBlocks"));
            entity.getWorld().createExplosion(x, y, z, power, setFire, breakBlocks);
        }
    }
}

