package me.almana.damageindicator.Commands;

import me.almana.damageindicator.DamageIndicator;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DamageIndicatorCommand implements TabExecutor {

    private Plugin plugin = DamageIndicator.getPlugin();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase("damageindicator")) {

            if (args.length > 0) {

                if (args[0].equalsIgnoreCase("disable")) {

                    TextComponent message = Component.text("[Damage Indicator] ", TextColor.color(27, 141, 255))
                            .append(Component.text("Disabling plugin...").color(TextColor.color(243, 141, 102)));
                    sender.sendMessage(message);
                    plugin.getServer().getPluginManager().disablePlugin(plugin);
                } else if (args[0].equalsIgnoreCase("setItem")) {

                    if (args.length > 1 && args[1].equalsIgnoreCase("true") || args[1].equalsIgnoreCase("false")) {

                        TextComponent message = Component.text("[Damage Indicator] ", TextColor.color(27, 141, 255))
                                .append(Component.text("Set item indicator to ")).color(TextColor.color(197, 233, 127))
                                .append(Component.text(args[1])).color(TextColor.color(197, 233, 127));
                        sender.sendMessage(message);

                        Boolean b = Boolean.parseBoolean(args[1]);
                        plugin.getConfig().set("ITEM", b);
                        plugin.getConfig().set("ARMOR_STAND", !b);
                    } else {

                        TextComponent message = Component.text("[Damage Indicator] ", TextColor.color(27, 141, 255))
                                .append(Component.text("Usage: /damageindicator setitem [true/false]")).color(TextColor.color(243, 141, 102));
                        sender.sendMessage(message);
                    }
                } else if (args[0].equalsIgnoreCase("setstand")) {

                    if (args.length > 1 && args[1].equalsIgnoreCase("true") || args[1].equalsIgnoreCase("false")) {

                        TextComponent message = Component.text("[Damage Indicator] ", TextColor.color(27, 141, 255))
                                .append(Component.text("Set stand indicator to ")).color(TextColor.color(197, 233, 127))
                                .append(Component.text(args[1])).color(TextColor.color(197, 233, 127));
                        sender.sendMessage(message);

                        Boolean b = Boolean.parseBoolean(args[1]);
                        plugin.getConfig().set("ITEM", !b);
                        plugin.getConfig().set("ARMOR_STAND", b);
                    } else {

                        TextComponent message = Component.text("[Damage Indicator] ", TextColor.color(27, 141, 255))
                                .append(Component.text("Usage: /damageindicator setstand [true/false]")).color(TextColor.color(243, 141, 102));
                        sender.sendMessage(message);
                    }
                } else if (args[0].equalsIgnoreCase("onlyplayer")) {

                    if (args.length > 1 && args[1].equalsIgnoreCase("true") || args[1].equalsIgnoreCase("false")) {

                        TextComponent message = Component.text("[Damage Indicator] ", TextColor.color(27, 141, 255))
                                .append(Component.text("Set only player to ")).color(TextColor.color(197, 233, 127))
                                .append(Component.text(args[1])).color(TextColor.color(197, 233, 127));
                        sender.sendMessage(message);

                        Boolean b = Boolean.parseBoolean(args[1]);
                        plugin.getConfig().set("ONLY_PLAYER", b);
                    } else {

                        TextComponent message = Component.text("[Damage Indicator] ", TextColor.color(27, 141, 255))
                                .append(Component.text("Usage: /damageindicator onlyplayer [true/false]")).color(TextColor.color(243, 141, 102));
                        sender.sendMessage(message);
                    }
                } else if (args[0].equalsIgnoreCase("info")) {

                    TextComponent message = Component.text("[Damage Indicator] \n", TextColor.color(27, 141, 255))
                            .append(Component.text("Plugin Author: AlmanaX21\n").color(TextColor.color(253, 204, 87)))
                            .append(Component.text("Server Version: ").color(TextColor.color(253, 204, 87)))
                            .append(Component.text(plugin.getServer().getVersion()).color(TextColor.color(253, 204, 87)))
                            .append(Component.text("\n"))
                            .append(Component.text("--------------------\n").color(TextColor.color(102, 119, 112)))
                            .append(Component.text("Config\n")).color(TextColor.color(115, 145, 226))
                            .append(Component.text("Only Player: ").color(TextColor.color(115, 145, 226))).append(Component.text(plugin.getConfig().getBoolean("ONLY_PLAYER")))
                            .append(Component.newline())
                            .append(Component.text("X offset: ").color(TextColor.color(115, 145, 226)))
                            .append(Component.text(plugin.getConfig().getDouble("LOCATION.X")).color(TextColor.color(115, 145, 226))).append(Component.text("\n"))
                            .append(Component.text("Y offset: ").color(TextColor.color(115, 145, 226)))
                            .append(Component.text(plugin.getConfig().getDouble("LOCATION.Y")).color(TextColor.color(115, 145, 226))).append(Component.text("\n"))
                            .append(Component.text("Z offset: ").color(TextColor.color(115, 145, 226)))
                            .append(Component.text(plugin.getConfig().getDouble("LOCATION.Z")).color(TextColor.color(115, 145, 226)));
                    sender.sendMessage(message);
                } else if (args[0].equalsIgnoreCase("setoffset")) {
                    if (args.length == 4) {

                        double x = Double.parseDouble(args[1]);
                        double y = Double.parseDouble(args[2]);
                        double z = Double.parseDouble(args[3]);

                        plugin.getConfig().set("LOCATION.X", x);
                        plugin.getConfig().set("LOCATION.Y", y);
                        plugin.getConfig().set("LOCATION.Z", z);

                        TextComponent message = Component.text("[Damage Indicator] \n", TextColor.color(27, 141, 255))
                                .append(Component.text("X offset: ").color(TextColor.color(115, 145, 226)))
                                .append(Component.text(x).color(TextColor.color(115, 145, 226))).append(Component.text("\n"))
                                .append(Component.text("Y offset: ").color(TextColor.color(115, 145, 226)))
                                .append(Component.text(y).color(TextColor.color(115, 145, 226))).append(Component.text("\n"))
                                .append(Component.text("Z offset: ").color(TextColor.color(115, 145, 226)))
                                .append(Component.text(z).color(TextColor.color(115, 145, 226)));
                        sender.sendMessage(message);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        List<String> arg1 = new ArrayList<>();
        List<String> arg2 = new ArrayList<>();
        if (args.length == 1) {

            arg1.add("disable");
            arg1.add("info");
            arg1.add("onlyplayer");
            arg1.add("setoffset");

            return arg1;
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("onlyplayer")) {

                arg2.add("true");
                arg2.add("false");
                return arg2;
            }
        }
        return null;
    }
}
