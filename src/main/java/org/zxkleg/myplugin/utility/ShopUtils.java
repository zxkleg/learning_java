package org.zxkleg.myplugin.utility;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.zxkleg.myplugin.Plugin;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.gui.PagedGui;
import xyz.xenondevs.invui.gui.structure.Markers;
import xyz.xenondevs.invui.item.Item;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.impl.SimpleItem;
import xyz.xenondevs.invui.window.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopUtils {
    public static Gui generateShopGui() {
        List<Map<?, ?>> itemsFromConfig = Plugin.getInstance().getConfig().getMapList("items");
        List<Item> items = new ArrayList<>();
        for (Map<?, ?> itemFromConfig : itemsFromConfig) {
            items.add(new ShopItem(itemFromConfig));
        }
        return PagedGui.items()
                .setStructure(
                        "i i i i i i i i i",
                        "i i i i i i i i i",
                        ". . . < . > . . .")
                .addIngredient('i', Markers.CONTENT_LIST_SLOT_HORIZONTAL)
                .addIngredient('<', new BackItem())
                .addIngredient('>', new ForwardItem())
                .setContent(items)
                .build();
    }

    public static void openShopWindow(Player player) {
        Window window = Window.single()
                .setViewer(player)
                .setTitle(serialize(Component
                        .text("Hip Shop")))
                .setGui(generateShopGui())
                .build();
        window.open();
    }

    public static void openBuyConfirmWindow(Map<String, Object> itemData, Player player) {
        Gui gui = PagedGui.items()
                .setStructure("X . i . >")
                .addIngredient('X', new CancelItem())
                .addIngredient('i', new SimpleItem((ItemProvider) itemData.get("item-builder")))
                .addIngredient('>', new ConfirmItem(itemData))
                .build();
        Window window = Window.single()
                .setViewer(player)
                .setTitle(serialize(Component
                        .text("Купить ")
                        .append((Component) itemData.get("name"))
                        .append(Component.text("?"))))
                .setGui(gui)
                .build();
        window.open();
    }

    public static String serialize(Component text) {
        return LegacyComponentSerializer.legacySection().serialize(text);
    }
}
