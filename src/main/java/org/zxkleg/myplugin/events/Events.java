package org.zxkleg.myplugin.events;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Events implements Listener {
    @EventHandler
    public void onJump(PlayerJumpEvent jumpEvent){
        Player player = (Player) jumpEvent.getPlayer();
        player.sendMessage("Молодец!");
    }
}
