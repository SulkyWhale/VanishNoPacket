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
package org.kitteh.vanish;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("fakejoin");
            completions.add("fakequit");
            completions.add("fq");
            completions.add("fj");
            completions.add("on");
            completions.add("off");
            completions.add("toggle");
            completions.add("t");
            completions.add("effects");
            completions.add("e");
            completions.add("check");
            completions.add("list");
            completions.add("reload");
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("fakequit")||args[0].equalsIgnoreCase("fakejoin")) {
                completions.add("force");
                completions.add("f");
            }
            if (args[0].equalsIgnoreCase("on")||args[0].equalsIgnoreCase("off")) {
                completions.add("fake");
            }
            if (args[0].equalsIgnoreCase("toggle")||args[0].equalsIgnoreCase("t")) {
                completions.add("see");
                completions.add("nopickup");
                completions.add("nofollow");
                completions.add("nointeract");
                completions.add("noohunger");
                completions.add("nochat");
                completions.add("chests");
                completions.add("damage-in");
                completions.add("damage-out");
            }
            if (args[0].equalsIgnoreCase("effects")||args[0].equalsIgnoreCase("e")) {
                completions.add("smoke");
                completions.add("explode");
                completions.add("lightning");
                completions.add("flames");
                completions.add("bats");
            }
        }
        return completions;
    }
}
