package com.ruralnetwork.plugin.util;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class PermLib {

    public static void init(PluginManager pm) {
        pm.addPermission(CMD_GM);
        pm.addPermission(CMD_RANK);
        pm.addPermission(CMD_RANK_STAFF);
        pm.addPermission(CMD_SPAWN);
    }

    public static final Permission CMD_GM = new Permission("rn.cmd.gm");
    public static final Permission CMD_RANK = new Permission("rn.cmd.rank");
    public static final Permission CMD_RANK_STAFF = new Permission("rn.cmd.rank.staff");
    public static final Permission CMD_SPAWN = new Permission("rn.cmd.spawn");
}
