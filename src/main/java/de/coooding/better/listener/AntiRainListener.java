package de.coooding.better.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class AntiRainListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
}
