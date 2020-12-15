package com.github.imalwayscoding.vanish.command

import com.github.imalwayscoding.vanish.VanishPlugin
import com.github.imalwayscoding.vanish.util.whileActionBar
import com.github.noonmaru.kommand.KommandBuilder
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object KommandVanish {

    val invisibleList = arrayListOf<Player>()

    fun register(builder: KommandBuilder) {
        builder.apply {
            then("vanish") {
                require { this is Player }
                executes {
                    val hidePlayer = it.sender as Player
                    if (invisibleList.contains(hidePlayer)) {
                        invisibleList.remove(hidePlayer)
                        hidePlayer.sendMessage("§cYou are now visible!")
                    } else {
                        for (player in Bukkit.getServer().onlinePlayers) {
                            player.hidePlayer(VanishPlugin.plugin, hidePlayer)
                        }
                        invisibleList.add(hidePlayer)
                        whileActionBar.showActionBarWhile(hidePlayer)
                    }
                }
            }
        }
    }
}
