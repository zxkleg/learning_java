package org.zxkleg.myplugin.events;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataType;
import org.zxkleg.myplugin.Plugin;

public class TeleportBowListener implements Listener {
    @EventHandler
    public void onBowShoot(EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        if (!(event.getBow().getItemMeta().getPersistentDataContainer().has(NamespacedKey.fromString("is_telepot_bow")))) {
            return;
        }
        event.getProjectile()
                .getPersistentDataContainer()
                .set(NamespacedKey.fromString("player_name"), PersistentDataType.STRING, event.getEntity().getName());
    }

    @EventHandler
    public void onArrowLand(ProjectileHitEvent event) {
        if (!(event.getEntityType() == EntityType.ARROW)) {
            return;
        }
        if (!(event.getEntity().getShooter() instanceof Player player)) {
            return;
        }
        String playerName = event.getEntity()
                .getPersistentDataContainer()
                .get(NamespacedKey.fromString("player_name"),
                        PersistentDataType.STRING);
        if (playerName == null) {
            return;
        }
        if (!(playerName.equalsIgnoreCase(player.getName()))) {
            return;
        }
        Location location = event.getEntity().getLocation();
        location.setYaw(player.getLocation().getYaw());
        location.setPitch(player.getLocation().getPitch());
        player.teleport(location);

        event.getEntity().remove();

        player.sendMessage(
                Component.text(Plugin.getInstance().getConfig().getString("teleported-message"))
                        .color(NamedTextColor.GREEN));
    }
}
