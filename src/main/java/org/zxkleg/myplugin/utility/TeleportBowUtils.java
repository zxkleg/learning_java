package org.zxkleg.myplugin.utility;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.zxkleg.myplugin.Plugin;

public class TeleportBowUtils {
    public static ItemStack createTeleportBow(){
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();

        bowMeta.setDisplayName(Plugin.getInstance().getConfig().getString("bow-name"));

        bowMeta.setLore(Plugin.getInstance().getConfig().getStringList("bow-description"));

        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);

        bowMeta.getPersistentDataContainer().set(NamespacedKey.fromString("is_telepot_bow"), PersistentDataType.STRING, "easter egg");

        bow.setItemMeta(bowMeta);

        return bow;
    }
}
