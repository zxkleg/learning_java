package org.zxkleg.myplugin.utility;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;

import java.util.Map;

import static org.zxkleg.myplugin.utility.ShopUtils.openShopWindow;
import static org.zxkleg.myplugin.utility.ShopUtils.serialize;

public class ConfirmItem extends AbstractItem {
    private final Map<String, Object> itemData;

    public ConfirmItem(Map<String, Object> itemData) {
        this.itemData = itemData;
    }

    @Override
    public ItemProvider getItemProvider() {
        return new ItemBuilder(Material.GREEN_TERRACOTTA)
                .setDisplayName(serialize(Component
                        .text("ДА", NamedTextColor.GREEN)
                        .decorate(TextDecoration.ITALIC)));
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        int playerDiamonds = 0;
        for (ItemStack is : player.getInventory().getContents()) {
            if (is == null) {
                continue;
            }
            if (is.getType() == Material.DIAMOND) {
                playerDiamonds += is.getAmount();
            }
        }
        int remainPay = (int) itemData.get("price");
        if (playerDiamonds < remainPay) {
            player.sendMessage(Component
                    .text("Недостаточно алмазов", NamedTextColor.RED));
            openShopWindow(player);
            return;
        }
        if(player.getInventory().getItemInOffHand().getType() == Material.DIAMOND){
            int amountInOffHand = player.getInventory().getItemInOffHand().getAmount();
            player.getInventory().setItemInOffHand((amountInOffHand > remainPay)
                    ? new ItemStack(Material.DIAMOND, amountInOffHand - remainPay)
                    : null);
            remainPay -= amountInOffHand;
        }
        for (ItemStack del : player.getInventory().getContents()) {
            if (del == null) {
                continue;
            }
            if (del.getType() == Material.DIAMOND && remainPay > 64) {
                player.getInventory().removeItem(del);
                remainPay -= 64;
                continue;
            }
            if(remainPay <= 0){
                break;
            }
            player.getInventory().removeItem(new ItemStack(Material.DIAMOND, remainPay));
            break;
        }

        ItemStack item = new ItemStack((Material) itemData.get("material"), (int) itemData.get("count"));
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName((Component) itemData.get("name"));
        item.setItemMeta(itemMeta);

        player.getInventory().addItem(item);
        player.updateInventory();
        player.sendMessage(Component
                .text("Вы успешно купили ", NamedTextColor.GREEN)
                .append(((Component) itemData.get("name")).color(NamedTextColor.GREEN)));
        openShopWindow(player);
    }
}
