package com.ruralnetwork.plugin.command;

import com.ruralnetwork.plugin.RuralNetwork;
import com.ruralnetwork.plugin.util.PermLib;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMCommand implements CommandExecutor {

    private final RuralNetwork plugin;

    public GMCommand(RuralNetwork plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;
        String gm = args[0];

        if (cmd.getName().equalsIgnoreCase("gm")) {
            if (!(source instanceof Player)) {
                return true;
            }
            if (!(source.hasPermission(PermLib.CMD_GM))) {
                return true;
            }
            Player player = (Player) source;
            if (gm.equalsIgnoreCase("s") || gm.equalsIgnoreCase("0")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.GREEN + "GameMode set to survival.");
            } else if (gm.equalsIgnoreCase("c") || gm.equalsIgnoreCase("1")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.GREEN + "GameMode set to creative.");
            }
            return true;
        }
        return false;
    }
}
