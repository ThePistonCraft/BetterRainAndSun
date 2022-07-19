package de.coooding.better;

import de.coooding.better.listener.AntiRainListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.List;

public class BetterRain extends JavaPlugin {

    @Getter
    public static BetterRain instance;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aThe BetterRainAndSun was created by §eCoooding");
        Bukkit.getConsoleSender().sendMessage("§aThe Support §bDiscord§7: §ehttps://discord.gg/8WjfsxZEzX");

        Bukkit.getPluginManager().registerEvents(new AntiRainListener(), this);
        instance = this;

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                getInstance().alwaysDay();
            }
        }, 0L, 15 * 20);
    }

    public void alwaysDay() {
        List<World> worlds = getServer().getWorlds();
        int worldCount = worlds.size();
        for (int i = 0; i < worldCount; i++) {
            World world = worlds.get(i);
            if (world.getEnvironment().equals(World.Environment.NORMAL)) {
                world.setTime(6000);
            }
        }
    }
}
