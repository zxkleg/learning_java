package org.zxkleg.myplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.zxkleg.myplugin.Plugin;

@CommandAlias("food")
public class FavouriteFood extends BaseCommand {
    @Default
    public void onFavouriteFood(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Команда может быть выполнена только оператором, не консолью");
            return;
        }
        if (args.length > 0) {
            String newFavouriteFood = String.join(" ", args);
            Plugin.getInstance().getConfig().set("favourite-food", newFavouriteFood);
            Plugin.getInstance().saveConfig();
            player.sendMessage("Любимая еда была изменена на " + newFavouriteFood);

        } else {
            player.sendMessage("Любимая еда - " + Plugin.getInstance().getConfig().getString("favourite-food"));
        }
    }
}
