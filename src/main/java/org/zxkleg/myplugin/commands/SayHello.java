package org.zxkleg.myplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("hello")
public class SayHello extends BaseCommand {
    @Default
    @CommandPermission("minecraft.command.op")
    public void onSayHello(CommandSender sender) {
        if (sender instanceof Player player) {
            player.sendMessage("Привет, " + player.getName() + "!");
        } else {
            sender.sendMessage("Команда может быть выполнена только оператором, не консолью");
        }
    }
}
