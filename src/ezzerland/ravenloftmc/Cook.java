package ezzerland.ravenloftmc;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import ezzerland.ravenloftmc.commands.CookCommand;
import ezzerland.ravenloftmc.commands.Reload;
import ezzerland.ravenloftmc.resource.Cookable;
import ezzerland.ravenloftmc.resource.Cookable.Cooked;

public class Cook extends JavaPlugin
{
  private HashMap<Material, Cooked> cookable;
  private Cookable materials;
  
  public void onEnable()
  {
    saveDefaultConfig();
    materials = new Cookable();
    cookable = new HashMap<Material, Cooked>();
    cookable = materials.getCookableMaterials();
    getCommand("cook").setExecutor(new CookCommand(this));
    getCommand("cookreload").setExecutor(new Reload(this));
  }
  
  public Cooked getCooked(Material toCook)
  {
    if (cookable.containsKey(toCook))
    {
      return cookable.get(toCook);
    }
    return null;
  }
  
  public void doReload() { reloadConfig(); } //Reload config.yml
  /* Correct color codes or replace text if provided */
  public String CleanMessage (String message) { return message.replaceAll("&", "\247"); }
 
}