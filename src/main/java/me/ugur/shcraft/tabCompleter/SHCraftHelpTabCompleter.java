package me.ugur.shcraft.tabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class SHCraftHelpTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> SHCraftHelp = new ArrayList<>();
            SHCraftHelp.add("1");
            SHCraftHelp.add("2");
            SHCraftHelp.add("3");

            return SHCraftHelp;
        }
        return null;
    }
}
