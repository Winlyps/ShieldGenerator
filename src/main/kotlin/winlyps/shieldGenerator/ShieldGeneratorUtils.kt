package winlyps.shieldGenerator

import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.block.Banner
import org.bukkit.block.banner.Pattern
import org.bukkit.block.banner.PatternType
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BlockStateMeta
import java.util.*

object ShieldGeneratorUtils {

    fun generateShields(numberOfShields: Int): List<ItemStack> {
        val shields = mutableListOf<ItemStack>()
        repeat(numberOfShields) {
            shields.add(generateRandomShield())
        }
        return shields
    }

    private fun generateRandomShield(): ItemStack {
        val shield = ItemStack(Material.SHIELD)
        val meta = shield.itemMeta as BlockStateMeta

        val banner = (meta.blockState as Banner)
        val random = Random()
        val patterns = mutableListOf<Pattern>()

        // Add random patterns to the shield
        repeat(random.nextInt(5) + 1) {
            val color = DyeColor.values()[random.nextInt(DyeColor.values().size)]
            val patternType = PatternType.values()[random.nextInt(PatternType.values().size)]
            patterns.add(Pattern(color, patternType))
        }

        banner.patterns = patterns
        banner.update()
        meta.blockState = banner
        shield.itemMeta = meta
        return shield
    }
}