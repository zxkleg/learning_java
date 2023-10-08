package org.zxkleg.myplugin;


import co.aikar.commands.BukkitCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.zxkleg.myplugin.commands.FavouriteFood;
import org.zxkleg.myplugin.commands.SayHello;
import org.zxkleg.myplugin.events.Events;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin is setting!!");

        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new Events(), this);

        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new SayHello());
        manager.registerCommand(new FavouriteFood(this));

        getLogger().info("Plugin is working!!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has turned off!!");
    }


}
