package checkpoint;

import com.avaje.ebean.validation.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Checkpoint {

    private float x,y,z;
    private String world;

    public Checkpoint()
    {
        x = Float.parseFloat(null);
        y = Float.parseFloat(null);
        z = Float.parseFloat(null);
        world = null;
    }

    public Checkpoint(String world, float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
    }

    public float distance(Checkpoint other)
    {
        return (float) Math.sqrt(square(this.x - other.x) + square(this.y - other.x) + square(this.z - other.z));
    }

    public boolean isOnCheckpoint(Player player)
    {
        return (player.getLocation().getBlockX() == (int)this.x) && (player.getLocation().getBlockY() == (int)this.y) && (player.getLocation().getBlockZ() == (int)this.z);
    }

    private float square(float number)
    {
        return number * number;
    }

    public Location getCheckpoint()
    {
        return new Location(Bukkit.getWorld(world), this.x, this.y, this.z);
    }

}
