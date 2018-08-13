package event;

import main.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BreakEvent implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Block block = event.getBlock();
        Material material = block.getType();

        if (Main.getInstance().getMaterialManager().containsMaterial(material)) {
            new BukkitRunnable() {
                int i = 10;
                @Override
                public void run() {
                    --i;
                    if (i == 0) {
                        block.setType(material);
                        cancel();
                    }
                }

            }.runTaskTimer(Main.getInstance(), 0, 20);
        }
        else
        {
        }
    }
}
