package com.github.imalwayscoding.vanish.listener

import com.github.imalwayscoding.vanish.VanishPlugin
import com.github.imalwayscoding.vanish.command.KommandVanish
import com.github.imalwayscoding.vanish.util.whileActionBar
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinListener : Listener {

    private val invisibleList = KommandVanish.invisibleList

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player

        if (invisibleList.contains(player)) {
            for (players in Bukkit.getServer().onlinePlayers) {
                players.hidePlayer(VanishPlugin.plugin, player)
            }
            whileActionBar.showActionBarWhile(player)
        }
    }
}