package nl.officialfox.skyblock.examples;

import nl.officialfox.skyblock.Command;
import org.bukkit.command.CommandSender;

public class ExampleCommand extends Command {
    @Override
    public String getName() {
        return "example";
    }

    @Override
    public String getDescription() {
        return "An example command ( For Jelle )";
    }

    @Override
    public String getUsage() {
        return "/example <arg1> <arg2>";
    }

    @Override
    public boolean onCommand(CommandSender sender, String label, String[] args) {
       // Handle command
        return false;
    }
}
