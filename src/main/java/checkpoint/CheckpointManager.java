package checkpoint;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckpointManager {

    private ArrayList<Checkpoint> checkpoints = new ArrayList<>();
    private HashMap<Player, Checkpoint> checkpointHashMap = new HashMap<>();

    private HashMap<Player, HashMap<Checkpoint, Checkpoint>> testcheckpointHashMap = new HashMap<>();
    public Checkpoint nextCheckpoint(Player player)
    {
        return testcheckpointHashMap.get(player).get(checkpointHashMap.get(player));
    }


    public Checkpoint getCheckpoint(Player player) {
        return checkpointHashMap.get(player);
    }

    public void setCheckpoint(Player player, Checkpoint checkpoint)
    {
        checkpointHashMap.put(player, checkpoint);
    }

    public boolean hasCheckpoint(Player player)
    {
        return checkpointHashMap.containsKey(player);
    }

    public void addCheckpoint(Checkpoint checkpoint)
    {
        checkpoints.add(checkpoint);
    }

    public Checkpoint isOnCheckpoint(Player player)
    {
        if(hasCheckpoint(player))
        {
            Checkpoint checkpoint = checkpointHashMap.get(player);
            player.sendMessage("X: " + checkpoint.getCheckpoint().getBlockX());
            player.sendMessage("Y: " + checkpoint.getCheckpoint().getBlockY());
            player.sendMessage("Z: " + checkpoint.getCheckpoint().getBlockZ());
            if((player.getLocation().getBlockX() == checkpoint.getCheckpoint().getBlockX())
                    && (player.getLocation().getBlockY() == checkpoint.getCheckpoint().getBlockY())
                    && (player.getLocation().getBlockZ() == checkpoint.getCheckpoint().getBlockZ()))
            {
                return checkpoint;
            }
        }

        return null;
    }

    public Checkpoint newCheckpoint(String world, int x, int y, int z)
    {
        return new Checkpoint(world, x, y, z);
    }

}
