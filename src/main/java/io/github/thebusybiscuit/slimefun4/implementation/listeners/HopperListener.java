package io.github.thebusybiscuit.slimefun4.implementation.listeners;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;

import io.github.thebusybiscuit.slimefun4.core.attributes.NotHopperable;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.AutoBrewer;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.AutoDrier;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricFurnace;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricIngotPulverizer;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricOreGrinder;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricSmeltery;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;

/**
 * This {@link Listener} prevents item from being transferred to
 * and from {@link AContainer} using a hopper.
 *
 * @author CURVX
 *
 * @see AutoBrewer
 * @see AutoDrier
 * @see ElectricFurnace
 * @see ElectricIngotPulverizer
 * @see ElectricOreGrinder
 * @see ElectricSmeltery
 *
 */
public class HopperListener implements Listener {

    public HopperListener(@Nonnull SlimefunPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onHopperInsert(InventoryMoveItemEvent e) {
        Location loc = e.getDestination().getLocation();
        if (e.getSource().getType() == InventoryType.HOPPER && loc != null && BlockStorage.check(loc.getBlock()) instanceof NotHopperable) {
            e.setCancelled(true);
        }
    }
}
