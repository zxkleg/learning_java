package org.zxkleg.myplugin.utility;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import xyz.xenondevs.invui.gui.PagedGui;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.controlitem.PageItem;

import static org.zxkleg.myplugin.utility.ShopUtils.serialize;

public class ForwardItem extends PageItem {

    public ForwardItem() {
        super(true);
    }

    @Override
    public ItemProvider getItemProvider(PagedGui<?> gui) {
        ItemBuilder builder = new ItemBuilder(Material.OAK_SIGN);
        builder.setDisplayName(serialize(
                        Component.text("Следующая страница", NamedTextColor.GRAY)))
                .addLoreLines(serialize(
                        gui.hasNextPage()
                                ? Component.text("Перейти на страницу ", NamedTextColor.GRAY)
                                .append(Component.text(gui.getCurrentPage() + 2, NamedTextColor.YELLOW))
                                .append(Component.text("/", NamedTextColor.GRAY))
                                .append(Component.text(gui.getPageAmount(), NamedTextColor.YELLOW))
                                : Component.text("Вы на последней странице", NamedTextColor.RED)));
        return builder;
    }

}
