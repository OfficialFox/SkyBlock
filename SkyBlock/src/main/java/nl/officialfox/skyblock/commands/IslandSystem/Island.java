package nl.officialfox.skyblock.commands.IslandSystem;

import java.util.UUID;

public class Island {
    private UUID owner;
    private IslandSettings settings;

    public Island(UUID owner){
        this.owner = owner;
        this.settings = new IslandSettings();
    }

    public UUID getOwner(){
        return owner;
    }

    public IslandSettings getSettings(){
        return settings;
    }
}
