package me.ugur.shcraft;

import me.ugur.shcraft.commands.*;
import me.ugur.shcraft.listeners.CitybuildListener;
import me.ugur.shcraft.listeners.JoinEvent;
import me.ugur.shcraft.listeners.NavigatorListener;
import me.ugur.shcraft.tabCompleter.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static Main plugin;
    public ArrayList<Player> invisible_list = new ArrayList<>();
    public static String prefix = ChatColor.AQUA + "" + ChatColor.BOLD +  "SHCraft" + ChatColor.RESET + " : ";
    public static String changeTimeToDay = prefix + "Die Zeit wurde erfolgreich auf Tag umgestellt!";
    public static String changeTimeToNight = prefix + "Die Zeit wurde erfolgreich auf Tag umgestellt!";
    public static String changeSelfGamemodeToSurvival = prefix + "Dein Gamemode wurde auf SURVIVAL gesetzt!";
    public static String changeSelfGamemodeToCreative = prefix + "Dein Gamemode wurde auf CREATIVE gesetzt!";
    public static String changeSelfGamemodeToAdventure = prefix + "Dein Gamemode wurde auf ADVENTURE gesetzt!";
    public static String changeSelfGamemodeToSpectator = prefix + "Dein Gamemode wurde auf SPECTATOR gesetzt!";
    public static String changeAllGamemodeToSurvival = prefix + "Der Gamemode von allem wurde auf SURVIVAL gesetzt!";
    public static String changeAllGamemodeToCreative = prefix + "Der Gamemode von allem wurde auf CREATIVE gesetzt!";
    public static String changeAllGamemodeToAdventure = prefix + "Der Gamemode von allem wurde auf ADVENTURE gesetzt!";
    public static String changeAllGamemodeToSpectator = prefix + "Der Gamemode von allem wurde auf SPECTATOR gesetzt!";
    public static String healThePlayerAndCountTheOldHealth = prefix + "Deine Leben wurden auf 20 Herzen gesetzt!";
    public static String repairTheItemInHand = prefix + "Das Item, welches du in deiner Hand hälts, wurde repariert!";
    public static String cannotRepairANotDuarbilityItem = prefix + "Das Item, welches du in deiner Hand hälts, konnte nicht repariert werden!";

    @Override
    public void onEnable() {

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        registerListeners();
        registerCommands();
        TabCompleterRegistration();

    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinEvent(this), this);
        pm.registerEvents(new NavigatorListener(), this);
        pm.registerEvents(new CitybuildListener(), this);
        pm.registerEvents(new ChatMuteCommand(), this);
    }

    private void TabCompleterRegistration() {
        this.getCommand("gamemode").setTabCompleter(new GamemodeTabCompleter());
        this.getCommand("gm").setTabCompleter(new GamemodeTabCompleter());
        this.getCommand("lobby").setTabCompleter(new LobbyTabCompleter());
        this.getCommand("l").setTabCompleter(new LobbyTabCompleter());
        this.getCommand("citybuild").setTabCompleter(new CitybuildTabCompleter());
        this.getCommand("cb").setTabCompleter(new CitybuildTabCompleter());
        this.getCommand("message").setTabCompleter(new MessageTabCompleter());
        this.getCommand("shcrafthelp").setTabCompleter(new SHCraftHelpTabCompleter());
        this.getCommand("shchelp").setTabCompleter(new SHCraftHelpTabCompleter());
    }

    private void registerCommands() {
        this.getCommand("gamemode").setExecutor(new GamemodeCommand());
        this.getCommand("gm").setExecutor(new GamemodeCommand());
        this.getCommand("lobby").setExecutor(new LobbyCommand(this));
        this.getCommand("l").setExecutor(new LobbyCommand(this));
        this.getCommand("citybuild").setExecutor(new CitybuildCommand(this));
        this.getCommand("cb").setExecutor(new CitybuildCommand(this));
        this.getCommand("vanish").setExecutor(new VanishCommand(this));
        this.getCommand("v").setExecutor(new VanishCommand(this));
        this.getCommand("day").setExecutor(new DayCommand());
        this.getCommand("tag").setExecutor(new DayCommand());
        this.getCommand("navigator").setExecutor(new NavigatorCommand());
        this.getCommand("nav").setExecutor(new NavigatorCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("repair").setExecutor(new RepairCommand());
        this.getCommand("test").setExecutor(new TestCommand());
        this.getCommand("message").setExecutor(new MessageCommand());
        this.getCommand("chatmute").setExecutor(new ChatMuteCommand());
        this.getCommand("cm").setExecutor(new ChatMuteCommand());
        this.getCommand("kickall").setExecutor(new KickAllCommand());
        this.getCommand("shcrafthelp").setExecutor(new SHCraftHelpCommand());
        this.getCommand("shchelp").setExecutor(new SHCraftHelpCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return plugin;
    }
}