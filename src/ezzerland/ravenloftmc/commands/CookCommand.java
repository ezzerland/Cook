package ezzerland.ravenloftmc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ezzerland.ravenloftmc.Cook;
import ezzerland.ravenloftmc.resource.Cookable.Cooked;

public class CookCommand implements CommandExecutor
{
  private Cook cook;
  public CookCommand (Cook plugin) { cook=plugin; }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  { // Ignore Console
    if (!(sender instanceof Player)) { return false; }
    
    // Cook whole inventory?
    if ((args.length == 1) && (args[0].equalsIgnoreCase("all")) && (sender.hasPermission("cook.command.all")))
    {
      for (ItemStack item : ((Player)sender).getInventory().getContents())
      { // Make sure there is an item in this inventory slot
        if (item != null)
        { // Grab the cooked version of this item and validate it
          Cooked material = cook.getCooked(item.getType());
          if ((material != null) && (sender.hasPermission(material.permission)))
          { // Cook it :)
            item.setType(material.material);
          }
        }
      }
      return true;
    }
    
    // Cook hand
    if (sender.hasPermission("cook.command.hand"))
    {
      
    }
    return false;
  }
}