package click.seichi.observerutils

import org.bukkit.plugin.java.JavaPlugin

class ObserverUtils extends JavaPlugin {
  override def onEnable(): Unit = {
    this.getLogger.info("ObserverUtils is enabled!")
  }
}
