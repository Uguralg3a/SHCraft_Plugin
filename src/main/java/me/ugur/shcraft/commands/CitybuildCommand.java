package me.ugur.shcraft.commands;

import me.ugur.shcraft.Main;
import me.ugur.shcraft.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CitybuildCommand implements CommandExecutor {

    private final Main plugin;

    public CitybuildCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player p = (Player) sender;
        Inventory i = Bukkit.createInventory(null, 6 * 9, "Citybuild");
        i.setItem(13, new ItemBuilder(Material.OAK_DOOR).setDisplayname("Citybuild").setLocalizedName("citybuild").build());
        i.setItem(38, new ItemBuilder(Material.GRASS_BLOCK).setDisplayname("Farmwelt").setLocalizedName("farmwelt").build());
        i.setItem(40, new ItemBuilder(Material.NETHERRACK).setDisplayname("Nether").setLocalizedName("nether").build());
        i.setItem(42, new ItemBuilder(Material.END_STONE).setDisplayname("End").setLocalizedName("end").build());


        p.openInventory(i);
        return false;
    }
}
