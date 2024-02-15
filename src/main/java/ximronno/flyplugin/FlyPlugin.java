package ximronno.flyplugin;

import org.bukkit.plugin.java.JavaPlugin;
import ximronno.flyplugin.commands.Fly;
import ximronno.flyplugin.commands.FlyConfig;
import ximronno.flyplugin.tabCompleter.FlyConfigTabCompleter;

public final class FlyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        System.out.println("[FlyPlugin] Hello World!");

        saveDefaultConfig();

        getCommand("fly").setExecutor(new Fly(this));

        getCommand("fly-config").setExecutor(new FlyConfig(this));

        getCommand("fly-config").setTabCompleter(new FlyConfigTabCompleter(this));

    }

    @Override
    public void onDisable() {
        System.out.println("[FlyPlugin] Bye!");
    }
}
