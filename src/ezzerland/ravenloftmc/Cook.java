package ezzerland.ravenloftmc;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import ezzerland.ravenloftmc.commands.CookCommand;
import ezzerland.ravenloftmc.resource.Cookable;
import ezzerland.ravenloftmc.resource.Cookable.Cooked;

public class Cook extends JavaPlugin
{
  private HashMap<Material, Cooked> cookable;
  private Cookable materials;
  
  public void onEnable()
  {
    materials = new Cookable();
    cookable = new HashMap<Material, Cooked>();
    cookable = materials.getCookableMaterials();
    getCommand("cook").setExecutor(new CookCommand(this));
  }
  
  public Cooked getCooked(Material toCook)
  {
    if (cookable.containsKey(toCook))
    {
      return cookable.get(toCook);
    }
    return null;
  }
}