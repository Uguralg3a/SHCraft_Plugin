package me.ugur.shcraft.listeners;

import me.ugur.shcraft.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class NavigatorListener implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if (e.getView().getTitle().equalsIgnoreCase("Navigator")) {
            System.out.println("Der Navigator Listener funktioniert");
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "citybuild":
                        p.performCommand("citybuild");
                        p.closeInventory();
                        break;
                    case "survival":
                        p.performCommand("survival");
                        p.closeInventory();
                        break;
                    case "lobby":
                        p.performCommand("lobby");
                        p.closeInventory();
                        break;
                }
            }
        }
    }
}

