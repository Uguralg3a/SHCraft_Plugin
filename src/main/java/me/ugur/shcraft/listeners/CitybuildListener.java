package me.ugur.shcraft.listeners;

import me.ugur.shcraft.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class CitybuildListener implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if (e.getView().getTitle().equalsIgnoreCase("Citybuild")) {
            System.out.println("Der Citybuild Listener funktioniert");
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "citybuild":
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                            public void run() {
                                sendToServer(p, "Citybuild");
                            }
                        }, 10);
                        p.closeInventory();
                        break;
                    case "farmwelt":
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                            public void run() {
                                sendToServer(p, "Farmwelt");
                            }
                        }, 10);
                        p.closeInventory();
                        break;
                    case "nether":
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                            public void run() {
                                sendToServer(p, "Nether");
                            }
                        }, 10);
                        p.closeInventory();
                        break;
                    case "end":
                        p.performCommand("css join End");
                        p.closeInventory();
                }
            }
        }
    }
    private static void sendToServer(Player p, String targetServer) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);
        try {
            dataOut.writeUTF("Connect");
            dataOut.writeUTF(targetServer);
        } catch(Exception e) {
            e.printStackTrace();
        }
        p.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
    }
}
