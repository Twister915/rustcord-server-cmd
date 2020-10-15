package sh.joey.rustcord;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class RustcordPlugin extends JavaPlugin {

    static final String PLUGIN_CHANNEL_ID = "rustcord:send";

    @Override
    public void onEnable() {
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, PLUGIN_CHANNEL_ID);
        getCommand("server").setExecutor(new ServerCommand(this));
    }

    static String colorify(String in) {
        return ChatColor.translateAlternateColorCodes('&', in);
    }
}
