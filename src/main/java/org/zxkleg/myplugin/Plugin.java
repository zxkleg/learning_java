package org.zxkleg.myplugin;


import co.aikar.commands.BukkitCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.zxkleg.myplugin.commands.FavouriteFood;
import org.zxkleg.myplugin.commands.GiveTeleportBow;
import org.zxkleg.myplugin.commands.SayHello;

import org.zxkleg.myplugin.events.Events;
import org.zxkleg.myplugin.events.TeleportBowListener;

public final class Plugin extends JavaPlugin {

    private static Plugin instance;
    @Override
    public void onEnable() {
        getLogger().info("Plugin is setting!!");

        instance = this;

        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new Events(), this);
        Bukkit.getPluginManager().registerEvents(new TeleportBowListener(), this);

        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new SayHello());
        manager.registerCommand(new FavouriteFood());
        manager.registerCommand(new GiveTeleportBow());

        getLogger().info("Plugin is working!!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has turned off!!");
    }
    public static Plugin getInstance() {
        return instance;
    }

}
