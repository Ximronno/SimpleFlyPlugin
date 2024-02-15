package ximronno.flyplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ximronno.flyplugin.FlyPlugin;

import java.util.ArrayList;

public class Fly implements CommandExecutor {

    private final FlyPlugin plugin;

    public Fly(FlyPlugin plugin){
        this.plugin = plugin;
    }

    private ArrayList<Player> list_of_flying_players = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("You are not a player!");
                return true;
            }
            Player player = (Player) sender;
            flyToggle(player);
        }
        else if(args.length == 1) {
            if(sender.hasPermission("flyPlugin.flyToOthers")) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null) {
                    sender.sendMessage("Player not found");
                }
                else {
                    flyToggle(target);
                }
            }
            else {
                sender.sendMessage("You do not have permission to give fly to others!");
            }
        }
        else{
            return false;
        }
        return true;
    }
    public void flyToggle(Player player) {
        if (list_of_flying_players.contains(player)) {

            list_of_flying_players.remove(player);
            player.setAllowFlight(false);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("fly-disabled-message")));

        } else {

            list_of_flying_players.add(player);
            player.setAllowFlight(true);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("fly-enabled-message")));

        }
    }
}
