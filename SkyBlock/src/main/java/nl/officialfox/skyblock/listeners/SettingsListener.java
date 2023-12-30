package nl.officialfox.skyblock.listeners;

import nl.officialfox.skyblock.commands.IslandSystem.IslandSettings;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SettingsListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        ItemStack item = event.getCurrentItem();

        if (item.getType() == Material.IRON_SWORD) {
            handlePvpToggleClick(player, settings);
        }

    }

    public void handlePvpToggleClick(Player player, IslandSettings settings) {
        settings.setPvpEnabled(!settings.isPvpEnabled());
    }
