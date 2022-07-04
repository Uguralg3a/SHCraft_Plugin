package me.ugur.shcraft.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMuteCommand implements CommandExecutor, Listener {

    private volatile boolean chatEnabled = true;

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        if (!chatEnabled) {
            System.out.println("Der onAsyncPlayerChat Listener funktioniert!");
            event.setCancelled(true);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        chatEnabled = !chatEnabled;
        // See if the chatEnabled boolean is true if it is print the string 'Unmuted the chat' if not then 'Muted the chat'
        sender.sendMessage(ChatColor.GREEN + (chatEnabled ? "Unmuted den chat" : "Muted den chat"));

        return true;
    }
}
