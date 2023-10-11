package org.zxkleg.myplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.zxkleg.myplugin.utility.TeleportBowUtils;

@CommandAlias("teleporbow")
public class GiveTeleportBow extends BaseCommand{
    @Default
    public void onGiveTeleportBow(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Команда может быть выполнена только оператором, не консолью");
            return;
        }
        if (args.length == 0){
            giveCreatedTeleportBow(player);
            return;
        }
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null){
            player.sendMessage(
                    Component.text("Игрок ")
                            .color(NamedTextColor.RED)
                            .append(Component.text(args[0]))
                            .append(Component.text(" не найден на сервере")));
            return;
        }
        giveCreatedTeleportBow(target);
        player.sendMessage(
                Component.text("Лук телепорт был успешно выдан игроку")
                        .color(NamedTextColor.GREEN)
                        .append(Component.text(target.getName())));
    }
    private void giveCreatedTeleportBow(Player target){
        ItemStack bow = TeleportBowUtils.createTeleportBow();
        ItemStack arrow = TeleportBowUtils.createTeleportArrow(target.getName());
        target.getInventory().addItem(bow);
        target.getInventory().addItem(arrow);
        target.sendMessage(
                Component.text("Вам был успешно выдан Лук-телепорт и волшебная стрела")
                        .color(NamedTextColor.GREEN));
    }
}
