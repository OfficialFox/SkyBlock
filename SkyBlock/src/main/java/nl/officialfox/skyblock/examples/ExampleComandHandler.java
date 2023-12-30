package nl.officialfox.skyblock.examples;

import nl.officialfox.skyblock.Command;
import nl.officialfox.skyblock.CommandHandler;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class ExampleComandHandler implements CommandHandler {
   private Map<String, Command> commands = new HashMap<>();
    @Override
    public void registerCommand(Command command) {
        commands.put(command.getName(), command);
    }

    @Override
    public boolean onCommand(CommandSender sender, String label, String[] args) {
        Command command = commands.get(label);
        if(command == null){
            return false;
        }
        return command.onCommand(sender, label, args);
    }
}