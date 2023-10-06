package org.zxkleg.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.zxkleg.myplugin.events.Events;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin is working!!");

        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has turned off!!");
    }
}
