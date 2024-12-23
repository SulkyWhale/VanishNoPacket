/*
 * VanishNoPacket
 * Copyright (C) 2011-2022 Matt Baxter
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.kitteh.vanish.listeners;

import com.destroystokyo.paper.event.entity.PhantomPreSpawnEvent;
import com.destroystokyo.paper.event.entity.PlayerNaturallySpawnCreaturesEvent;
import com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent;
import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.kitteh.vanish.VanishPerms;
import org.kitteh.vanish.VanishPlugin;
import org.spigotmc.event.entity.EntityMountEvent;

public final class ListenPaper implements Listener {
    private final VanishPlugin plugin;

    public ListenPaper(@NonNull VanishPlugin instance) {
        this.plugin = instance;
    }

    @EventHandler(ignoreCancelled = true)
    public void onMount(@NonNull EntityMountEvent event) {
        if ((event.getMount() instanceof Player player) && this.plugin.getManager().isVanished(player) && VanishPerms.canNotInteract((player))) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onNaturalSpawn(@NonNull PlayerNaturallySpawnCreaturesEvent event) {
        if (this.plugin.getManager().isVanished(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPhantom(@NonNull PhantomPreSpawnEvent event) {
        if ((event.getSpawningEntity() instanceof Player player) && this.plugin.getManager().isVanished(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPickupExperience(@NonNull PlayerPickupExperienceEvent event) {
        if (this.plugin.getManager().isVanished(event.getPlayer()) && VanishPerms.canNotPickUp(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onProjectileCollide(@NonNull ProjectileHitEvent event) {
        if ((event.getHitEntity() instanceof Player player) && this.plugin.getManager().isVanished(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerAdvancementCriterionGrant(@NonNull PlayerAdvancementCriterionGrantEvent event) {
        if (this.plugin.getManager().isVanished(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onChat(@NonNull AsyncChatEvent event) {
        if (this.plugin.getManager().isVanished(event.getPlayer()) && VanishPerms.canNotChat(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
}
