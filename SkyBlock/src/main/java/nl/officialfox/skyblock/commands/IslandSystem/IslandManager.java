package nl.officialfox.skyblock.commands.IslandSystem;

import org.bukkit.entity.Player;

public class IslandManager {
    private IslandStorage storage;

    public Player getIslandOwner(String islandId) {
        return storage.getOwner(islandId);
    }

}