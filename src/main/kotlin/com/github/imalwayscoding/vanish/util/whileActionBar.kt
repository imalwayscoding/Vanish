package com.github.imalwayscoding.vanish.util

import com.github.imalwayscoding.vanish.command.KommandVanish
import org.bukkit.entity.Player

class whileActionBar {

    companion object {

        fun showActionBarWhile(player: Player) {

            val invisibleList = KommandVanish.invisibleList

            while (!invisibleList.contains(player)) {
                player.sendActionBar("you are currently §cVANISHED§f.")
            }
        }

    }

}