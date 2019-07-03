package ezzerland.ravenloftmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ezzerland.ravenloftmc.Cook;

public class CookReload implements CommandExecutor
{
  private Cook cook;
  public CookReload (Cook plugin) { cook=plugin; }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((!(sender instanceof Player)) || (sender.hasPermission("cook.reload")))
    {
      cook.doReload();
      sender.sendMessage(cook.CleanMessage(cook.getConfig().getString("reload")));
      return true;
    }
    return false;
  }
}