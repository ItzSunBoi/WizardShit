package me.itzsunboi.wizardshit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class giveitemcommands implements CommandExecutor {


    private final JavaPlugin plugin;

    public giveitemcommands(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    private ItemStack createVietnameseToaster() {
        // Your method to create the Vietnamese Toaster item
        // Similar to your ViemtneseToaster method, but returns the ItemStack
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta meta = bow.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + "Vietnamese Toaster");
            meta.setLore(Arrays.asList(ChatColor.RESET + "The Invisible Toast"));
            NamespacedKey key = new NamespacedKey(plugin, "CustomTag");
            meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            bow.setItemMeta(meta);
        }
        return bow;
    }

    private ItemStack createFloatyFish() {
        ItemStack customSalmon = new ItemStack(Material.SALMON);
        ItemMeta meta = customSalmon.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.BOLD + "Floaty Fish");
            meta.setLore(Arrays.asList(ChatColor.ITALIC + "La Salmon de le Float"));
            NamespacedKey key = new NamespacedKey(plugin, "CustomTag");
            meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            customSalmon.setItemMeta(meta);
        }
        return customSalmon;
    }
    private ItemStack createSugarDeLeSpeed() {
        // Create the base item
        ItemStack sugar = new ItemStack(Material.SUGAR);
        ItemMeta meta = sugar.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.ITALIC + "" + ChatColor.AQUA + "Sugar de le Speed");
            meta.setLore(Arrays.asList(ChatColor.RESET + "Fast as FUCK BOIIIIIIIIII"));
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            sugar.setItemMeta(meta);
        }
        return sugar;
    }
    private ItemStack createCopperBolt() {
        ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            NamespacedKey customTagKey = new NamespacedKey(plugin, "CustomTag");
            meta.getPersistentDataContainer().set(customTagKey, PersistentDataType.BYTE, (byte) 1);
            meta.setDisplayName("§lCopper Bolt");
            meta.setLore(Arrays.asList("§l§oLa Stick de le Death!"));
            item.setItemMeta(meta);
        }
        return item;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can execute this command.");
                return true;
            }

            Player player = (Player) sender;
            switch (args[0].toLowerCase()) {
                case "toaster":
                    player.getInventory().addItem(createVietnameseToaster());
                    player.sendMessage("You've received the Vietnamese Toaster!");
                    break;
                case "rod":
                    player.getInventory().addItem(createCopperBolt());
                    player.sendMessage("You've received the FUCKING ROD");
                    break;
                case "fish":
                    player.getInventory().addItem(createFloatyFish());
                    player.sendMessage("You've received the THE FUCKING FISH");
                    break;
                case "sugar":
                    player.getInventory().addItem(createSugarDeLeSpeed());
                    player.sendMessage("You've received COCAINE");
                    break;
                default:
                    player.sendMessage("Unknown subcommand.");
                    break;
            }
        } else {
            sender.sendMessage("Usage: /dumbshit <subcommand>");
        }
        return true;
    }
}

