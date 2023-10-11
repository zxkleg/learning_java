package org.zxkleg.myplugin.utility;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.zxkleg.myplugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class TeleportBowUtils {
    public static ItemStack createTeleportBow() {
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();

        bowMeta.displayName(Component.text(Plugin.getInstance().getConfig().getString("bow-name"))
                .color(NamedTextColor.GOLD)
                .decorate(TextDecoration.BOLD));

        bowMeta.lore(formatLoreFromConfig(Plugin.getInstance().getConfig().getStringList("bow-description")));

        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);

        bowMeta.getPersistentDataContainer().set(NamespacedKey.fromString("is_telepot_bow"), PersistentDataType.STRING, "easter egg");

        bow.setItemMeta(bowMeta);

        return bow;
    }
    public static ItemStack createTeleportArrow(String playerName){
        ItemStack arrow = new ItemStack(Material.ARROW, 1);
        ItemMeta arrowMeta = arrow.getItemMeta();

        arrowMeta.displayName(Component.text(Plugin.getInstance().getConfig().getString("arrow-name"))
                .color(NamedTextColor.GOLD)
                .decorate(TextDecoration.BOLD)
                .replaceText(config -> {
                    config.match("%playerName%");
                    config.replacement(playerName);}));

        arrowMeta.lore(formatLoreFromConfig(Plugin.getInstance().getConfig().getStringList("arrow-description")));

        arrow.setItemMeta(arrowMeta);
        return arrow;
    }
    public static List<Component> formatLoreFromConfig(List<String> lore){
        List<Component> formattedLore = new ArrayList<>();
        for (int i = 0; i != lore.size(); i++) {
            formattedLore.add(
                    Component.text(lore.get(i))
                            .color(NamedTextColor.LIGHT_PURPLE)
                            .decoration(TextDecoration.ITALIC, false));
        }
        return formattedLore;
    }
}
