package me.almana.damageindicator;

import me.almana.damageindicator.Commands.DamageIndicatorCommand;
import me.almana.damageindicator.Commands.PlayerStatCommand;
import me.almana.damageindicator.Listener.DamageListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DamageIndicator extends JavaPlugin {

    private static DamageIndicator plugin;

    public static DamageIndicator getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {

        plugin = this;
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        getServer().getPluginCommand("damageindicator").setExecutor(new DamageIndicatorCommand());
        getServer().getPluginCommand("playerstat").setExecutor(new PlayerStatCommand());
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Boolean enable = getConfig().getBoolean("ENABLE_PLUGIN");
        if (!enable) {

            this.getServer().getPluginManager().disablePlugin(this);
            Bukkit.getLogger().warning("[DAMAGE INDICATOR]:- Diabled itself due to config.");
        } else {

            Bukkit.getLogger().info("[DAMAGE INDICATOR]:- ENABLED SUCCESSFULLY.");
            Bukkit.getLogger().info("[DAMAGE INDICATOR]:- By AlmanaX21#3208");
        }

    }
}
