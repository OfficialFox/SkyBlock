package nl.officialfox.skyblock.commands;

import nl.officialfox.skyblock.Command;
import nl.officialfox.skyblock.commands.IslandSystem.Island;
import nl.officialfox.skyblock.commands.IslandSystem.IslandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IslandCommand extends Command {

    private final IslandManager islandManager;

    public IslandCommand(IslandManager islandManager) {
        this.islandManager = islandManager;
    }

    @Override
    public String getName() {
        return "island";
    }

    @Override
    public String getDescription() {
        return "Create and manage your own island!";
    }

    @Override
    public String getUsage() {
        return "/island";
    }

    @Override
    public boolean onCommand(CommandSender sender, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("islands.create")) {
            player.sendMessage("You do not have permission to create an island.");
            return true;
        }

        Island island = getIslandForPlayer(player);

        if (island != null) {
            player.sendMessage("You already have an island.");
            return true;
        }

        island = islandManager.createIsland(player.getUniqueId());
        island.teleportPlayer(player);

        player.sendMessage("Your new island has been created!");

        return true;
    }

    @Override
    public boolean onSubCommand(CommandSender sender, String label, String subCommand, String[] args) {
        // Handle subcommands
        return false;
    }

    private Island getIslandForPlayer(Player player) {
        return islandManager.getIsland(player.getUniqueId());
    }

}