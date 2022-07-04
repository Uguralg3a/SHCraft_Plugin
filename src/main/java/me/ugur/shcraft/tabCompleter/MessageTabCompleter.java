package me.ugur.shcraft.tabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MessageTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1) {
            List<String> Message = new ArrayList<>();
            Message.add("restart");
            Message.add("wartungsarbeiten");
            Message.add("event");

            return Message;
        }
        return null;
    }
}
