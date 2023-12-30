package nl.officialfox.skyblock;

import org.bukkit.command.CommandSender;

public interface CommandHandler {
    void registerCommand(Command command);
    boolean onCommand(CommandSender sender, String label, String[] args);
}
