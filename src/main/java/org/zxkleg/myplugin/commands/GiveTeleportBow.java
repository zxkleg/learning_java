package org.zxkleg.myplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.zxkleg.myplugin.utility.TeleportBowUtils;

@CommandAlias("teleporbow")
public class GiveTeleportBow extends BaseCommand{
    private void giveCreatedTeleportBow(Player target){
        ItemStack bow = TeleportBowUtils.createTeleportBow();
        target.getInventory().addItem(bow);
        target.getInventory().addItem(new ItemStack(Material.ARROW, 1));
        target.sendMessage(
                Component.text("Лук телепорт был успешно выдан игроку ")
                        .color(NamedTextColor.GREEN)
                        .append(Component.text(target.getName())));
    }
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
    }
}
