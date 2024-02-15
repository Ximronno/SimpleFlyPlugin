package ximronno.flyplugin.tabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import ximronno.flyplugin.FlyPlugin;

import java.util.List;

public class FlyConfigTabCompleter implements TabCompleter {

    private final FlyPlugin plugin;

    public FlyConfigTabCompleter(FlyPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 1) {
            return List.of(
                    "getEnabledMessage",
                    "getDisabledMessage",
                    "setEnabledMessage",
                    "setDisabledMessage"
            );
        }
        if(args.length == 2 && args[0].equalsIgnoreCase("setEnabledMessage")) {
            return List.of(
                    this.plugin.getConfig().getString("fly-enabled-message")
            );
        }
        if(args.length == 2 && args[0].equalsIgnoreCase("setDisabledMessage"))  {
            return List.of(
                    this.plugin.getConfig().getString("fly-disabled-message")
            );
        }
        return null;
    }
}
