package com.ruralnetwork.plugin;

import com.ruralnetwork.plugin.command.GMCommand;
import com.ruralnetwork.plugin.command.RankCommand;
import com.ruralnetwork.plugin.command.SpawnCommand;
import com.ruralnetwork.plugin.util.PermLib;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class RuralNetwork extends JavaPlugin {

    private final PluginManager pm = this.getServer().getPluginManager();

    @Override
    public void onDisable() {

        this.getLogger().log(Level.INFO, "Disabled");
    }

    @Override
    public void onEnable() {

        PermLib.init(pm);
        this.getCommand("gm").setExecutor(new GMCommand(this));
        this.getCommand("rank").setExecutor(new RankCommand(this));
        this.getCommand("spawn").setExecutor(new SpawnCommand(this));

        List<String> rankAliases = new ArrayList<String>();
        rankAliases.add("player");
        rankAliases.add("plus");
        rankAliases.add("vip");
        rankAliases.add("mvp");
        rankAliases.add("mod");
        rankAliases.add("admin");
        this.getCommand("rank").setAliases(rankAliases);

        this.getLogger().log(Level.INFO, "Enabled");
    }

    public int getServerId() {
        int port = this.getServer().getPort();
        if (port == 25566) {
            return 0; // hub
        } else if (port == 25567) {
            return 1; // oitc1
        } else if (port == 25568) {
            return 2; // sb1
        } else {
            return 999;
        }
    }
}
