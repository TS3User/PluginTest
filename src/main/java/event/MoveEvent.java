package event;

import checkpoint.Checkpoint;
import main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        player.sendMessage("N1");
        Checkpoint checkpoint = Main.getInstance().getCheckpointManager().isOnCheckpoint(player);
        if(checkpoint != null)
        {
            player.sendMessage("N2");
            player.sendMessage("Y1: " + player.getLocation().getBlockY() + " Y2: " + (checkpoint.getCheckpoint().getBlockY() - 5));
            if(player.getLocation().getBlockY() < checkpoint.getCheckpoint().getBlockY() - 5)
            {
                player.sendMessage("N3");
                player.teleport(checkpoint.getCheckpoint());
                player.sendMessage("Abstand zu nächstem Checkpoint: " + Main.getInstance().getCheckpointManager().newCheckpoint(player.getLocation().getWorld().getName(), player.getLocation().getBlockX() + 10, player.getLocation().getBlockY(), player.getLocation().getBlockZ()));// + checkpoint.distance()); TODO
            }
        }
    }

}
