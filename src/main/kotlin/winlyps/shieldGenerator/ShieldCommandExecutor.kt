package winlyps.shieldGenerator

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ShieldCommandExecutor(private val plugin: ShieldGenerator) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("This command can only be executed by a player.")
            return true
        }

        if (args.size != 1) {
            sender.sendMessage("Usage: /shieldgn <NumberOfGeneratedShieldsMax36>")
            return true
        }

        val numberOfShields = args[0].toIntOrNull()
        if (numberOfShields == null || numberOfShields < 1 || numberOfShields > 36) {
            sender.sendMessage("Invalid number of shields. Please provide a number between 1 and 36.")
            return true
        }

        val shields = ShieldGeneratorUtils.generateShields(numberOfShields)
        for (shield in shields) {
            sender.inventory.addItem(shield)
        }
        return true
    }
}