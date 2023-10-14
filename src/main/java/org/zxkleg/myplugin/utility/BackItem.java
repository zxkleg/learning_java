package org.zxkleg.myplugin.utility;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import xyz.xenondevs.invui.gui.PagedGui;
import xyz.xenondevs.invui.item.ItemProvider;

import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.controlitem.PageItem;

public class BackItem extends PageItem {

    public BackItem() {
        super(false);
    }

    @Override
    public ItemProvider getItemProvider(PagedGui<?> gui) {
        ItemBuilder builder = new ItemBuilder(Material.OAK_SIGN);
        builder.setDisplayName(ShopUtils.Serialize(
                        Component.text("Предыдущая страница", NamedTextColor.GRAY)))
                .addLoreLines(ShopUtils.Serialize(
                        gui.hasPreviousPage()
                                ? Component.text("Перейти на страницу ", NamedTextColor.GRAY)
                                .append(Component.text(gui.getCurrentPage(), NamedTextColor.YELLOW))
                                .append(Component.text("/", NamedTextColor.GRAY))
                                .append(Component.text(gui.getPageAmount(), NamedTextColor.YELLOW))
                                : Component.text("Вы на первой странице", NamedTextColor.RED)));
        return builder;
    }

}