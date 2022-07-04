package me.ugur.shcraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickAllCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (!(p != sender)) {
            return false;
        }
        for (Player target : Bukkit.getServer().getOnlinePlayers()){
            if (!target.isOp() || p.hasPermission("shcraft.command.kickall")) {
                target.kickPlayer("Alle wurden gekickt!");
            }
        }
        return false;
    }
}
