package nl.officialfox.skyblock;

import nl.officialfox.skyblock.commands.IsCommand;
import nl.officialfox.skyblock.commands.IslandCommand;
import nl.officialfox.skyblock.examples.ExampleComandHandler;
import nl.officialfox.skyblock.examples.ExampleCommand;
import org.bukkit.plugin.java.JavaPlugin;


public final class SkyBlock extends JavaPlugin {
    private CommandHandler commandHandler;
    public static SkyBlock instance;
    @Override
    public void onEnable() {
        instance = this;
        commandHandler = new ExampleComandHandler();
        commandHandler.registerCommand(new ExampleCommand());
        commandHandler.registerCommand(new IslandCommand());
        //Hier kunnen de andere commands!

    }

    @Override
    public void onDisable() {
        System.out.println("Plugin afgesloten!");
    }
}
