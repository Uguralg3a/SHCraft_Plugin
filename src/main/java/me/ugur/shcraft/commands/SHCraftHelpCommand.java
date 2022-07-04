package me.ugur.shcraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SHCraftHelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (!(p != sender)) {
            return false;
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("1")) {
                p.sendMessage("Site 1\n/chatmute & /cm: Schaltet den Chat Stumm/Frei\n/citybuild & /cb: Öffnet das CityBuild Teleporter Menü\n/day & /tag: Setzt die Zeit auf Tag\n/gamemode & /gm: Wechselt den Gamemode\n/heal: Heilt dich\nFür mehr nutze /help 2 oder /help 3");
            } else if (args[0].equalsIgnoreCase("2")) {
                p.sendMessage("Site 2\n/kickall: Kickt jeden, der nicht Op ist oder nicht die Rechte hat\n/lobby & /l: sendet dich zur Lobby\n/message: Sind eine Art alerts\n/navigator & /nav: Öffnet den Navigator\n/night & /nacht: setzt die Zeit auf Nacht\nFür mehr nutze /help 1 oder /help 3");
            } else if (args[0].equalsIgnoreCase("3")) {
                p.sendMessage("Site 3\n/repair: Repariert das Item in deiner Hand\n/shcrafthelp & /shchelp: Zeigt dir das an\n/test: ist zum testen\n/vanish & /v macht dich unsichtbar\nFür mehr nutze /help 1 oder /help 2");
            }
        }
        return false;
    }
}
