package commands;

import checkpoint.Checkpoint;
import checkpoint.CheckpointManager;
import main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddCheckpoint implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player)
        {
            if(cmd.getName().equalsIgnoreCase("addcheckpoint"))
            {
                Player player = (Player) sender;
                Checkpoint checkpoint = new Checkpoint(player.getWorld().getName(), (float)player.getLocation().getX(), (float)player.getLocation().getY(), (float)player.getLocation().getZ());
                Main.getInstance().getCheckpointManager().addCheckpoint(checkpoint);
                player.sendMessage("Neuer Checkpoint wurde gesetzt.");
            }
        }

        return false;
    }
}
