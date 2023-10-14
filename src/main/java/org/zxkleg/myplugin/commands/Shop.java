package org.zxkleg.myplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.zxkleg.myplugin.utility.BackItem;
import org.zxkleg.myplugin.utility.ForwardItem;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.gui.PagedGui;
import xyz.xenondevs.invui.gui.structure.Markers;
import xyz.xenondevs.invui.item.Item;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.SimpleItem;
import xyz.xenondevs.invui.window.Window;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CommandAlias("shop")
public class Shop extends BaseCommand {
    @Default
    public void onShop(CommandSender sender, String[] args){
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Команда может быть выполнена только игроком, не консолью");
            return;
        }
        List<Item> items = Arrays.stream(Material.values())
                .filter(material -> !material.isAir() && material.isItem())
                .map(material -> new SimpleItem(new ItemBuilder(material)))
                .collect(Collectors.toList());
        Gui gui = PagedGui.items()
                .setStructure(
                        "x x x x x x x x x",
                        "x x x x x x x x x",
                        ". . . < . > . . .")
                .addIngredient('x', Markers.CONTENT_LIST_SLOT_HORIZONTAL)
                .addIngredient('<', new BackItem())
                .addIngredient('>', new ForwardItem())
                .setContent(items)
                .build();
        Window window = Window.single()
                .setViewer(player)
                .setTitle("Hip Shop")
                .setGui(gui)
                .build();
        window.open();
    }
}
