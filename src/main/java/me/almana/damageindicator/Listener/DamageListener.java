package me.almana.damageindicator.Listener;


import me.almana.damageindicator.DamageIndicator;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

public class DamageListener implements Listener {

    Plugin plugin  = DamageIndicator.getPlugin();

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){

        Boolean onlyPlayer = plugin.getConfig().getBoolean("ONLY_PLAYER");


        if (onlyPlayer && e.getEntity() instanceof Player victim && e.getDamager() instanceof Player) {

            Location drop = victim.getEyeLocation().add(0, - 0.1, 0);

            if (e.isCritical()) {

                ArmorStand a = (ArmorStand) drop.getWorld().spawnEntity(drop, EntityType.ARMOR_STAND);
                a.setInvisible(true);
                a.setInvulnerable(true);
                a.setMarker(true);
                TextComponent c = Component.text(Math.round(e.getFinalDamage()), NamedTextColor.RED);
                a.setCustomNameVisible(true);
                a.setSmall(true);
                a.customName(c);
                Bukkit.getScheduler().runTaskLater(DamageIndicator.getPlugin(), a::remove,20L);
            } else {

                ArmorStand a = (ArmorStand) drop.getWorld().spawnEntity(drop, EntityType.ARMOR_STAND);
                a.setInvisible(true);
                a.setInvulnerable(true);
                a.setMarker(true);
                TextComponent c = Component.text(Math.round(e.getFinalDamage()), NamedTextColor.GOLD);
                a.setCustomNameVisible(true);
                a.setSmall(true);
                a.customName(c);
                Bukkit.getScheduler().runTaskLater(DamageIndicator.getPlugin(), a::remove,20L);
            }
        } else if (!onlyPlayer && e.getDamager() instanceof Player) {

            Entity victim = e.getEntity();
            Location drop = victim.getLocation().add(plugin.getConfig().getDouble("LOCATION.X"), plugin.getConfig().getDouble("LOCATION.Y"), plugin.getConfig().getDouble("LOCATION.Z"));

            if (e.isCritical()) {

                ArmorStand a = (ArmorStand) drop.getWorld().spawnEntity(drop, EntityType.ARMOR_STAND);
                a.setInvisible(true);
                a.setInvulnerable(true);
                a.setMarker(true);
                TextComponent c = Component.text(Math.round(e.getFinalDamage()), NamedTextColor.RED);
                a.setCustomNameVisible(true);
                a.setSmall(true);
                a.customName(c);
                Bukkit.getScheduler().runTaskLater(DamageIndicator.getPlugin(), a::remove,20L);
            } else {

                ArmorStand a = (ArmorStand) drop.getWorld().spawnEntity(drop, EntityType.ARMOR_STAND);
                a.setInvisible(true);
                a.setInvulnerable(true);
                a.setMarker(true);
                TextComponent c = Component.text(Math.round(e.getFinalDamage()), NamedTextColor.GOLD);
                a.setCustomNameVisible(true);
                a.setSmall(true);
                a.customName(c);

                Bukkit.getScheduler().runTaskLater(DamageIndicator.getPlugin(), a::remove,20L);
            }
        }
    }
}
