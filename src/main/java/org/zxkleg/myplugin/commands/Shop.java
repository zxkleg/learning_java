package org.zxkleg.myplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.zxkleg.myplugin.utility.ShopUtils.openShopWindow;


@CommandAlias("shop")
public class Shop extends BaseCommand {
    @Default
    public void onShop(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Команда может быть выполнена только игроком, не консолью");
            return;
        }
        openShopWindow(player);
    }
}
