package me.almana.damageindicator.Commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlayerStatCommand implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 0 && sender instanceof Player player) {

            int i = player.getStatistic(Statistic.DAMAGE_DEALT);
            int j = player.getStatistic(Statistic.DAMAGE_ABSORBED);

            TextComponent message = Component.text("[Damage Indicator] \n", TextColor.color(27, 141, 255))
                    .append(Component.text(player.getName()).color(TextColor.color(180, 118, 234)))
                    .append(Component.text("\n"))
                    .append(Component.text("Damage dealt: ").color(TextColor.color(180, 118, 234)))
                    .append(Component.text(i).color(TextColor.color(180, 118, 234)))
                    .append(Component.text("\n"))
                    .append(Component.text("Damage absorbed: ").color(TextColor.color(180, 118, 234)))
                    .append(Component.text(j).color(TextColor.color(180, 118, 234)));
            player.sendMessage(message);
        } else if (args.length == 1) {

            Player player = Bukkit.getPlayer(args[0]);

            if (!(player == null)) {

                int i = player.getStatistic(Statistic.DAMAGE_DEALT);
                int j = player.getStatistic(Statistic.DAMAGE_ABSORBED);

                TextComponent message = Component.text("[Damage Indicator] \n", TextColor.color(27, 141, 255))
                        .append(Component.text(player.getName()).color(TextColor.color(180, 118, 234)))
                        .append(Component.text("\n"))
                        .append(Component.text("Damage dealt: ").color(TextColor.color(180, 118, 234)))
                        .append(Component.text(i).color(TextColor.color(180, 118, 234)))
                        .append(Component.text("\n"))
                        .append(Component.text("Damage absorbed: ").color(TextColor.color(180, 118, 234)))
                        .append(Component.text(j).color(TextColor.color(180, 118, 234)));
                player.sendMessage(message);
            } else {

                TextComponent message = Component.text("[Damage Indicator] ", TextColor.color(27, 141, 255))
                        .append(Component.text("Player not found.").color(TextColor.color(188, 57, 80)));
                sender.sendMessage(message);
            }
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }
}
