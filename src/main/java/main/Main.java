package main;

import checkpoint.CheckpointManager;
import commands.AddCheckpoint;
import event.BreakEvent;
import event.MoveEvent;
import event.PlaceEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private MaterialManager materialManager = new MaterialManager();
    private CheckpointManager checkpointManager = new CheckpointManager();

    @Override
    public void onEnable()
    {
        instance = this;
        registerEvents();
    }

    private void registerEvents()
    {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BreakEvent(), this);
        pm.registerEvents(new PlaceEvent(), this);
        pm.registerEvents(new MoveEvent(), this);
        this.getCommand("addcheckpoint").setExecutor(new AddCheckpoint());
    }

    @Override
    public void onDisable()
    {
        instance = null;
    }

    public static Main getInstance() {
        return instance;
    }

    public MaterialManager getMaterialManager() {
        return materialManager;
    }

    public CheckpointManager getCheckpointManager() {
        return checkpointManager;
    }
}
