package me.ugur.shcraft.commands;

import me.ugur.shcraft.Main;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;
        World w = p.getWorld();

        w.setTime(18000);
        p.sendMessage(Main.changeTimeToNight);
        return false;
    }
}

