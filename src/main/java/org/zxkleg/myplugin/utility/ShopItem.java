package org.zxkleg.myplugin.utility;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;

import java.util.HashMap;
import java.util.Map;

import static org.zxkleg.myplugin.utility.ShopUtils.openBuyConfirmWindow;
import static org.zxkleg.myplugin.utility.ShopUtils.serialize;

public class ShopItem extends AbstractItem {
    private final Map<String, Object> itemData = new HashMap<>();

    public ShopItem(Map<?, ?> itemsFromConfig) {
        this.itemData.put("material", Material.valueOf((String) itemsFromConfig.get("material")));
        this.itemData.put("price", itemsFromConfig.get("price"));
        this.itemData.put("count", itemsFromConfig.get("count"));

        String itemCustomName = (String) itemsFromConfig.get("custom-name");
        if (itemCustomName == null) {
            this.itemData.put("name", Component.translatable(new ItemStack((Material) this.itemData.get("material"))));
        } else {
            this.itemData.put("name", Component.text((String) itemsFromConfig.get("custom-name")));
        }
        this.itemData.put("item-builder", new ItemBuilder((Material) this.itemData.get("material"))
                .setDisplayName(serialize((Component) this.itemData.get("name")))
                .addLoreLines(serialize(Component
                        .text("Стоимость ", NamedTextColor.GRAY)
                        .append(Component.text((int) this.itemData.get("price"), NamedTextColor.YELLOW))))
                .setAmount((int) itemData.get("count")));
    }

    @Override
    public ItemProvider getItemProvider() {
        return (ItemBuilder) this.itemData.get("item-builder");
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        openBuyConfirmWindow(this.itemData, player);
    }
}
