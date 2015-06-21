package com.ruralnetwork.plugin.command;

import com.ruralnetwork.plugin.RuralNetwork;
import com.ruralnetwork.plugin.util.PermLib;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final RuralNetwork plugin;

    public SpawnCommand(RuralNetwork plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (!(source instanceof Player)) {
                return true;
            }
            if (!(source.hasPermission(PermLib.CMD_SPAWN))) {
                source.sendMessage(ChatColor.RED + "You do not have permission to use that command.");
                return true;
            }
            if (length > 0) {
                source.sendMessage(ChatColor.RED + "Invalid Command Syntax.");
                return true;
            }
            Player player = (Player) source;
            String playerName = player.getName();
            if (plugin.getServerId() == 0) {
                teleportPlayer(playerName, 0, 65, 0);
            } else if (plugin.getServerId() == 1) {
                teleportPlayer(playerName, 0, 65, 0);
            } else if (plugin.getServerId() == 2) {
                teleportPlayer(playerName, 0, 65, 0);
            } else {
                player.sendMessage(ChatColor.RED + "com.ruralnetwork.plugin.io.IdException: Invalid Server ID");
                player.sendMessage(ChatColor.RED + "Please report this error to a server administrator.");
            }
            return true;
        }
        return false;
    }

    private void teleportPlayer(String playerName, int x, int y, int z) {
        CommandSender console = Bukkit.getConsoleSender();
        String xS = String.valueOf(x);
        String yS = String.valueOf(y);
        String zS = String.valueOf(z);
        Bukkit.dispatchCommand(console, "tp " + playerName + " " + xS + " " + yS + " " + zS);
    }
}
