package net.textr.cmd;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpMap;
import org.bukkit.help.HelpTopic;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Core
  extends JavaPlugin
  implements Listener
{
  public void onEnable()
  {
    Bukkit.getPluginManager().registerEvents(this, this);
    saveDefaultConfig();
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
  {
    Player player = event.getPlayer();
    String cmd = event.getMessage().split(" ")[0];
    HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
    if (event.isCancelled()) {
      return;
    }
    if (topic != null) {
      return;
    }
    Player p = event.getPlayer();
    p.sendTitle(getConfig().getString("UnCommand.linia1").replaceAll("&", "§").replaceAll("/command/", cmd), getConfig().getString("UnCommand.linia2").replaceAll("&", "§"));
    event.setCancelled(true);
  }
}
