package ximronno.flyplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ximronno.flyplugin.FlyPlugin;

public class FlyConfig implements CommandExecutor {

    private final FlyPlugin plugin;

    public FlyConfig(FlyPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args[0].equalsIgnoreCase("getEnabledMessage")) {
            getEnabledMessage(sender);
            return true;
        }
        else if(args[0].equalsIgnoreCase("getDisabledMessage")) {
            getDisabledMessage(sender);
            return true;
        }
        else {
            if(args.length >= 2) {
                if(args[0].equalsIgnoreCase("setEnabledMessage")) {
                    StringBuilder builder = new StringBuilder();
                    for(int i = 1; i <= args.length - 1; i++){
                        builder.append(args[i] + " ");
                    }
                    String text = builder.toString();
                    setEnabledMessage(sender,text);
                    return true;
                }
                else if(args[0].equalsIgnoreCase("setDisabledMessage")) {
                    StringBuilder builder = new StringBuilder();
                    for(int i = 1; i <= args.length - 1; i++){
                        builder.append(args[i] + " ");
                    }
                    String text = builder.toString();
                    setDisabledMessage(sender,text);
                    return true;
                }
            }
        }
        return false;
    }
    public void getEnabledMessage(CommandSender sender) {
        sender.sendMessage("Current raw enabled message is: " + this.plugin.getConfig().getString("fly-enabled-message"));
        sender.sendMessage("Current enabled message is: " + ChatColor.translateAlternateColorCodes('&',this.plugin.getConfig().getString("fly-enabled-message")));
    }
    public void getDisabledMessage(CommandSender sender) {
        sender.sendMessage("Current raw disabled message is: " + this.plugin.getConfig().getString("fly-disabled-message"));
        sender.sendMessage("Current disabled message is: " + ChatColor.translateAlternateColorCodes('&',this.plugin.getConfig().getString("fly-disabled-message")));
    }
    public void setEnabledMessage(CommandSender sender, String enabledMessage) {
        this.plugin.getConfig().set("fly-enabled-message", enabledMessage);
        this.plugin.saveConfig();
        sender.sendMessage("New raw enabled message is: " + enabledMessage);
    }
    public void setDisabledMessage(CommandSender sender, String disabledMessage) {
        this.plugin.getConfig().set("fly-disabled-message", disabledMessage);
        this.plugin.saveConfig();
        sender.sendMessage("New raw disabled message is: " + disabledMessage);
    }
}
