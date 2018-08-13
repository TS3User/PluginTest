package main;

import org.bukkit.Material;
import java.util.ArrayList;

public class MaterialManager {

    private ArrayList<Material> materials = new ArrayList<>()
    {{
        add(Material.DIAMOND_BLOCK);
        add(Material.REDSTONE_BLOCK);
    }};


    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void addMaterial(Material material)
    {
        materials.add(material);
    }

    public void removeMaterial(Material material)
    {
        materials.remove(material);
    }

    public boolean containsMaterial(Material material)
    {
        return materials.contains(material);
    }
}
