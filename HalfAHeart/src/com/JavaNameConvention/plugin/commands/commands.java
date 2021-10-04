package com.JavaNameConvention.plugin.commands;

import com.mojang.brigadier.exceptions.CommandExceptionType;
import javafx.print.PageLayout;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("halfaheart")) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.setMaxHealth(1);
            }
        }
        return true;
    }
}
