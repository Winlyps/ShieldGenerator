package winlyps.shieldGenerator

import org.bukkit.plugin.java.JavaPlugin

class ShieldGenerator : JavaPlugin() {

    override fun onEnable() {
        // Register the command executor
        getCommand("shieldgn")?.setExecutor(ShieldCommandExecutor(this))
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}