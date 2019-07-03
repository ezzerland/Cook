package ezzerland.ravenloftmc.resource;

import java.util.HashMap;

import org.bukkit.Material;

public class Cookable
{
  
  public Cookable() {}
  
  public HashMap<Material, Cooked> getCookableMaterials()
  {
    HashMap<Material, Cooked> cookable = new HashMap<Material, Cooked>();
    // Food
    cookable.put(Material.POTATO, new Cooked(Material.BAKED_POTATO, "cook.potato"));
    cookable.put(Material.RABBIT, new Cooked(Material.COOKED_RABBIT, "cook.rabbit"));
    cookable.put(Material.MUTTON, new Cooked(Material.COOKED_MUTTON, "cook.mutton"));
    cookable.put(Material.PORKCHOP, new Cooked(Material.COOKED_PORKCHOP, "cook.porkchop"));
    cookable.put(Material.CHICKEN, new Cooked(Material.COOKED_CHICKEN, "cook.chicken"));
    cookable.put(Material.BEEF, new Cooked(Material.COOKED_BEEF, "cook.beef"));
    cookable.put(Material.SALMON, new Cooked(Material.COOKED_SALMON, "cook.salmon"));
    cookable.put(Material.COD, new Cooked(Material.COOKED_COD, "cook.cod"));
    cookable.put(Material.KELP, new Cooked(Material.DRIED_KELP, "cook.kelp"));
    // It's a possibility to add non-food materials later
    // Smelt List: https://minecraft.gamepedia.com/Smelting
    // Just don't forget to update plugin.yml with any new permissions!
    return cookable;
  }
  
  public class Cooked {
    public Material material;
    public String permission;
    public Cooked (Material mat, String perm) { material = mat; permission = perm; }
  }
}