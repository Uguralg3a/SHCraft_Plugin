package me.ugur.shcraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player p = (Player) sender;

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("restart")) {
                Bukkit.broadcastMessage("§f===============================");
                Bukkit.broadcastMessage("                   §eRestart");
                Bukkit.broadcastMessage("    ");
                Bukkit.broadcastMessage("§eDer Server wird bald gerestartet!");
                Bukkit.broadcastMessage("     ");
                Bukkit.broadcastMessage("    ");
                Bukkit.broadcastMessage("§f===============================");
            } else if (args[0].equalsIgnoreCase("wartungsarbeiten")){
                Bukkit.broadcastMessage("§f===============================");
                Bukkit.broadcastMessage("                   §eWartungsarbeiten");
                Bukkit.broadcastMessage("    ");
                Bukkit.broadcastMessage("§eDer Server wird bald in Wartungsarbeiten geschickt!");
                Bukkit.broadcastMessage("     ");
                Bukkit.broadcastMessage("    ");
                Bukkit.broadcastMessage("§f===============================");
            } else if (args[0].equalsIgnoreCase("event")) {
                Bukkit.broadcastMessage("§f===============================");
                Bukkit.broadcastMessage("                   §eEvent");
                Bukkit.broadcastMessage("    ");
                Bukkit.broadcastMessage("§eDer Server wird bald ein Event haben!");
                Bukkit.broadcastMessage("     ");
                Bukkit.broadcastMessage("    ");
                Bukkit.broadcastMessage("§f===============================");
            }
        }
        return false;
    }
}
