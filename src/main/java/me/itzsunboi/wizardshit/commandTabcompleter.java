package me.itzsunboi.wizardshit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class commandTabcompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        // Add your autocomplete options here
        completions.add("Toaster");
        completions.add("Fish");
        completions.add("Rod");
        completions.add("Sugar");
        return completions;
    }
}
