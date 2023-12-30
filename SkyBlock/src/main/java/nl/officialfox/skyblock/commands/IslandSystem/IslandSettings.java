package nl.officialfox.skyblock.commands.IslandSystem;

import nl.officialfox.skyblock.SkyBlock;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.*;

public class IslandSettings {

    private boolean pvpEnabled;
    private int maxMembers;

    private boolean allowVisitors;
    private VisitorPermission visitorPermissions;

    private boolean isOpen;
    private String openMessage;
    private String closedMessage;

    private List<Material> allowedBlocks;
    private boolean restrictBlockPlacement;

    private String islandName;

    private List<Player> members;
    private List<Player> bannedPlayers;

    private double bankBalance;

    public boolean canVisit(Player player) {
        return !bannedPlayers.contains(player) && members.size() < maxMembers;
    }

    public void setVisitorPermissions(VisitorPermission perm) {
        this.visitorPermissions = perm;
    }

    public void openIsland(String openMessage) {
        this.isOpen = true;
        this.openMessage = openMessage;
    }

    public void demoteMember(Player member) {

        if (!members.contains(member)) {
            return;
        }

        members.remove(member);

        removePermission(member, "island.member");

        member.sendMessage("You have been demoted from the island");

        if (members.isEmpty()) {
            Player owner = getIslandOwner();
            members.add(owner);
            addPermission(owner, "island.member");
        }

    }

    public void depositFunds(double amount) {
        bankBalance += amount;
    }

    private Map<Player, List<String>> playerPermissions = new HashMap<>();

    public void removePermission(Player player, String perm) {

        List<String> perms = playerPermissions.get(player);
        if (perms != null) {
            perms.remove(perm);
        }

        updatePlayer(player);

    }

    public Player getIslandOwner() {

        // Get the player instance
        Player player = Bukkit.getPlayer(UUID.randomUUID());

        // Get current island based on player's location
        Island island = getIslandByLocation(player.getLocation());

        if (island != null) {

            // Get owner UUID
            UUID ownerUUID = island.getOwner();

            // Lookup owner Player from UUID
            return Bukkit.getPlayer(ownerUUID);

        }

        return null;

    }
    private List<Island> islands;
    private Island getIslandByLocation(Location location) {
        for(Island island : islands){
            if(islands.contains(location)){
                return island;
            }
        }

        return null;
    }


    public void addPermission(Player player, String perm) {

        List<String> perms = playerPermissions.get(player);
        if (perms == null) {
            perms = new ArrayList<>();
            playerPermissions.put(player, perms);
        }
        perms.add(perm);

        updatePlayer(player);

    }

    private void updatePlayer(Player player) {

        List<String> perms = playerPermissions.get(player);

        player.getEffectivePermissions().clear();

        if (perms != null) {
            for (String perm : perms) {
                player.addAttachment(SkyBlock.instance, perm, true);
            }
        }

        player.recalculatePermissions();

    }

}