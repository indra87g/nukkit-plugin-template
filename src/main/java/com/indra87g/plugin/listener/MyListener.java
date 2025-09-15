package com.indra87g.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import com.indra87g.plugin.Main;

public class MyListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String message = Main.getInstance().getConfig().getString("welcome-message");
        message = message.replace("{player}", event.getPlayer().getName());
        event.getPlayer().sendMessage(message);
    }
}
