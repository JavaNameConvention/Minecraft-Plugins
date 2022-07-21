package com.JavaNameConvention.plugin;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player) commandSender;
        if (command.getName().equalsIgnoreCase("track")) {
            try {
                ItemStack item = new ItemStack(Material.COMPASS);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("Player Tracker");
                meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
                List<String> lore = new ArrayList<>();
                lore.add("Tracks ");
                lore.add(args[0]);
                meta.setLore(lore);
                item.setItemMeta(meta);
                player.getInventory().addItem(item);
                    /*
                    // get player name
                    // get player location
                    Player toTrack = Bukkit.getPlayer(args[0]);
                    assert toTrack != null;
                    Location trackingLocation = toTrack.getLocation();

                    // give compass to person with special id of who to track
                    ItemStack itemStack = new ItemStack(Material.COMPASS);
                    player.getInventory().addItem(itemStack);
                    player.sendMessage("Right click the compass to update player location");
                    NamespacedKey key = new NamespacedKey((Plugin) this, args[0]);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    assert itemMeta != null;
                    itemMeta.getCustomTagContainer().setCustomTag(key, ItemTagType.DOUBLE, Math.PI);
                    itemStack.setItemMeta(itemMeta);

                     */

            } catch (Exception ignored) {
                player.sendMessage(ChatColor.GRAY + "[CompassTracker] Uh oh, did you type the command correctly? type /track for usage");
                player.sendMessage(String.valueOf(ignored));
            }
        }
        return true;
    }
}
