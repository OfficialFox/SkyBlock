package nl.officialfox.skyblock;

import org.bukkit.command.CommandSender;

public abstract class Command {

    public abstract String getName();
    public abstract String getDescription();
    public abstract String getUsage();
    public abstract boolean onCommand(CommandSender sender, String label, String[] args);
    public abstract boolean onSubCommand(CommandSender sender, String label, String subCommand, String[] args);

}