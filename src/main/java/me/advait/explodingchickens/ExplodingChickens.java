package me.advait.explodingchickens;

import me.advait.explodingchickens.listeners.BlockBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExplodingChickens extends JavaPlugin {

    private static ExplodingChickens instance;

    public static ExplodingChickens getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

}
