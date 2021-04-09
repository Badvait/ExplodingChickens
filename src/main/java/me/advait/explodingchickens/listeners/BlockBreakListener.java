package me.advait.explodingchickens.listeners;

import me.advait.explodingchickens.ExplodingChickens;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        int random = new Random().nextInt(5);
        if (random != 1) return;
        Location location = event.getBlock().getLocation();
        World world = location.getWorld();
        world.spawnEntity(location, EntityType.CHICKEN);
        event.getPlayer().playSound(location, Sound.ENTITY_CREEPER_PRIMED, 20, 1);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(ExplodingChickens.getInstance(), () -> {
            world.createExplosion(location, 4F);
        }, 20 * 2);
    }

}
