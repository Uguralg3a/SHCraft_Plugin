package me.ugur.shcraft.commands;

import me.ugur.shcraft.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("zero")) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(Main.changeSelfGamemodeToSurvival);
            }
            if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("one")) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(Main.changeSelfGamemodeToCreative);
            }
            if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("two")) {
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(Main.changeSelfGamemodeToAdventure);
            }
            if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("three")) {
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(Main.changeSelfGamemodeToSpectator);
            }
        }
        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("@a")) {
                if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("zero")) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.setGameMode(GameMode.SURVIVAL);
                        pl.sendMessage(Main.changeAllGamemodeToSurvival);
                    }
                } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("one")) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.setGameMode(GameMode.CREATIVE);
                        pl.sendMessage(Main.changeAllGamemodeToCreative);
                    }
                } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("two")) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.setGameMode(GameMode.ADVENTURE);
                        pl.sendMessage(Main.changeAllGamemodeToAdventure);
                    }
                } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("three")) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.setGameMode(GameMode.SPECTATOR);
                        pl.sendMessage(Main.changeAllGamemodeToSpectator);
                    }
                }

            } else {
                try {
                    Player s = Bukkit.getPlayer(args[1]);
                    if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("zero")) {
                        s.setGameMode(GameMode.SURVIVAL);
                        s.sendMessage(Main.changeSelfGamemodeToSurvival);
                    } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("one")) {
                        s.setGameMode(GameMode.CREATIVE);
                        s.sendMessage(Main.changeSelfGamemodeToCreative);
                    } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("two")) {
                        s.setGameMode(GameMode.ADVENTURE);
                        s.sendMessage(Main.changeSelfGamemodeToAdventure);
                    } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("three")) {
                        s.setGameMode(GameMode.SPECTATOR);
                        s.sendMessage(Main.changeSelfGamemodeToCreative);
                    }
                } catch (Exception e) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        pl.sendMessage(Main.prefix + "Der Spieler §9" + args[0] + " §7 konnte §cnicht gefunden §7werden.");
                    }
                }
            }
        }
        return false;
    }
}


