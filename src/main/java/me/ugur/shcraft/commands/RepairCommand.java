package me.ugur.shcraft.commands;

import me.ugur.shcraft.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Repairable;

public class RepairCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player p = (Player) sender;

        ItemStack mainHand = p.getItemInHand();

        if (mainHand.getItemMeta() instanceof Repairable) {
            p.getInventory().getItemInMainHand().setDurability((short) 0);
            p.sendMessage(Main.repairTheItemInHand);
        } else {
            p.sendMessage(Main.cannotRepairANotDuarbilityItem);
        }
        return false;
    }
}
