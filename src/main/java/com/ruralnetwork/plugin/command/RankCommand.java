package com.ruralnetwork.plugin.command;

import com.ruralnetwork.plugin.RuralNetwork;
import com.ruralnetwork.plugin.util.PermLib;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RankCommand implements CommandExecutor {

    private final RuralNetwork plugin;

    public RankCommand(RuralNetwork plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;
        String player = args[0];
        CommandSender console = Bukkit.getConsoleSender();

        //TODO Handle command length and failed permissions

        if (cmd.getName().equalsIgnoreCase("rank")) {
            if (!(source.hasPermission(PermLib.CMD_RANK))) {
                return true;
            }

            if (alias.equalsIgnoreCase("player")) {
                Bukkit.dispatchCommand(console, "pex user " + player + " group set Player");
                source.sendMessage(ChatColor.GREEN + "Users group set.");
            } else if (alias.equalsIgnoreCase("plus")) {
                Bukkit.dispatchCommand(console, "pex user " + player + " group set Plus");
                source.sendMessage(ChatColor.GREEN + "Users group set.");
            } else if (alias.equalsIgnoreCase("vip")) {
                Bukkit.dispatchCommand(console, "pex user " + player + " group set VIP");
                source.sendMessage(ChatColor.GREEN + "Users group set.");
            } else if (alias.equalsIgnoreCase("mvp")) {
                Bukkit.dispatchCommand(console, "pex user " + player + " group set MVP");
                source.sendMessage(ChatColor.GREEN + "Users group set.");
            } else if (alias.equalsIgnoreCase("mod")) {
                if (!(source.hasPermission(PermLib.CMD_RANK_STAFF))) {
                    return true;
                }
                Bukkit.dispatchCommand(console, "pex user " + player + " group set Mod");
                source.sendMessage(ChatColor.GREEN + "Users group set.");
            } else if (alias.equalsIgnoreCase("admin")) {
                if (!(source.hasPermission(PermLib.CMD_RANK_STAFF))) {
                    return true;
                }
                Bukkit.dispatchCommand(console, "pex user " + player + " group set Admin");
                source.sendMessage(ChatColor.GREEN + "Users group set.");
            } else {
                source.sendMessage(ChatColor.GREEN + "Invalid Syntax!");
                source.sendMessage(ChatColor.DARK_GREEN + "/player /plus /vip /mvp /mod /admin");
            }
            return true;
        }
        return false;
    }
}
