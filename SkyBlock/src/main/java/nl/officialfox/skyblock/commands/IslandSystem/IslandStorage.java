package nl.officialfox.skyblock.commands.IslandSystem;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class IslandStorage {

    private Map<String, Island> islands = new HashMap<>();

    public IslandStorage() {
        // TODO: Implement loading islands from database
    }

    public Player getOwner(String islandId) {

        Island island = islands.get(islandId);

        if(island != null) {

            UUID ownerUuid = island.getOwner();

            Player owner = Bukkit.getPlayer(ownerUuid);
            return owner;

        }

        return null;
    }
}