package com.github.imalwayscoding.vanish

import com.github.imalwayscoding.vanish.command.KommandVanish
import com.github.noonmaru.kommand.kommand
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin

class VanishPlugin : JavaPlugin() {

    companion object {

        lateinit var plugin: Plugin

    }

    override fun onEnable() {
        plugin = this
        logger.info("vanish plugin enabled.")
    }

    override fun onDisable() {
        logger.info("vanish plugin disabled.")
    }

    fun registerCommands() = kommand {
        register("vanish") {
            KommandVanish.register(this)
        }
    }

}