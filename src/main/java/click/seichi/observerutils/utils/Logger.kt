package click.seichi.observerutils.utils

import click.seichi.observerutils.utils.LoggerLevel.*
import org.bukkit.Bukkit

/**
 * [java.util.logging.Level]のうち一般的に有効であろうと思われるロギングレベルを表現する
 */
enum class LoggerLevel {
    INFO, WARN, SEVERE
}

/**
 * [org.bukkit.Server.getLogger]をラップしている
 */
object Logger {
    private val logger = Bukkit.getServer().logger

    fun log(messages: List<String>, level: LoggerLevel = INFO) = when (level) {
        INFO -> info(messages)
        WARN -> warn(messages)
        SEVERE -> severe(messages)
    }

    fun info(message: String) = info(listOf(message))
    fun info(messages: List<String>) = messages.forEach { logger.info(it) }
    fun warn(message: String) = warn(listOf(message))
    fun warn(messages: List<String>) = messages.forEach { logger.warning(it) }
    fun severe(message: String) = severe(listOf(message))
    fun severe(messages: List<String>) = messages.forEach { logger.severe(it) }
}