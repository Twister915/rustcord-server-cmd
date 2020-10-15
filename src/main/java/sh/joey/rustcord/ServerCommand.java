package sh.joey.rustcord;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static sh.joey.rustcord.RustcordPlugin.PLUGIN_CHANNEL_ID;
import static sh.joey.rustcord.RustcordPlugin.colorify;

public class ServerCommand implements CommandExecutor {

    private final RustcordPlugin plugin;

    ServerCommand(RustcordPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(colorify("&cneed to be a player!"));
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage(colorify("&cmust specify a server!"));
            return true;
        }

        Player player = (Player) sender;
        String server = args[0];
        sender.sendMessage(colorify("&csending to &f" + server));
        player.sendPluginMessage(plugin, PLUGIN_CHANNEL_ID, server.getBytes());
        return true;
    }
}
