package me.itzsunboi.wizardshit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public final class WizardShit extends JavaPlugin {
    public void CopperBolt(NamespacedKey recipeKey) {
        ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK); // Output item
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            // Set a custom tag
            NamespacedKey customTagKey = new NamespacedKey(this, "CustomTag");
            meta.getPersistentDataContainer().set(customTagKey, PersistentDataType.BYTE, (byte) 1);

            // Set the display name
            meta.setDisplayName("§lCopper Bolt"); // §l is the formatting code for bold

            // Set the lore
            meta.setLore(Arrays.asList("§l§oLa Stick de le Death!")); // §l for bold, §o for italic

            item.setItemMeta(meta);
        }

        // Define the custom recipe
        ShapedRecipe recipe = new ShapedRecipe(recipeKey, item);

        recipe.shape(" QS", " RQ", "N  ");
        recipe.setIngredient('Q', Material.QUARTZ);
        recipe.setIngredient('S', Material.NETHER_STAR);
        recipe.setIngredient('R', Material.BLAZE_ROD);
        recipe.setIngredient('N', Material.NETHERITE_INGOT);

        // Add the recipe to the server
        getServer().addRecipe(recipe);
    }
    public void SugerSped(NamespacedKey recipeKey) {
        ItemStack sugar = new ItemStack(Material.SUGAR);

        // Get and check the ItemMeta
        ItemMeta meta = sugar.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.ITALIC + "" + ChatColor.AQUA + "Sugar de le Speed");
            meta.setLore(Arrays.asList(ChatColor.RESET + "Fast as FUCK BOIIIIIIIIII"));
            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            sugar.setItemMeta(meta);

        }


        // Define the custom recipe
        ShapedRecipe recipe = new ShapedRecipe(recipeKey, sugar);

        recipe.shape("SSS", "SCS", "SSS");
        recipe.setIngredient('C', Material.SUGAR_CANE);
        recipe.setIngredient('S', Material.SUGAR);
        // Add the recipe to the server
        getServer().addRecipe(recipe);
    }

    public void ViemtneseToaster(NamespacedKey recipeKey) {
        ItemStack bow = new ItemStack(Material.BOW);

        // Get and check the ItemMeta
        ItemMeta meta = bow.getItemMeta();
        if (meta != null) {
            // Set the display name with italic, blue color, and bold
            meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.ITALIC + "" + ChatColor.BOLD + "Vietnamese Toaster");

            // Set the lore
            meta.setLore(Arrays.asList(ChatColor.RESET + "The Invisible Toast"));

            // Add a custom tag using PersistentDataContainer
            NamespacedKey key = new NamespacedKey(this, "CustomTag");
            meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);

            meta.addEnchant(Enchantment.LUCK, 1, true);

            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            // Apply the meta to the bow item
            bow.setItemMeta(meta);
        }



        // Define the custom recipe
        ShapedRecipe recipe = new ShapedRecipe(recipeKey, bow);

        recipe.shape("GBG", "BGB", "GBG");
        recipe.setIngredient('G', Material.LIGHT_GRAY_STAINED_GLASS_PANE);
        recipe.setIngredient('B', Material.BOW);
        // Add the recipe to the server
        getServer().addRecipe(recipe);
    }
    private void FloatyFish() {
        // Create the custom salmon item
        ItemStack customSalmon = new ItemStack(Material.SALMON);

        // Get and set the ItemMeta for custom name and lore
        ItemMeta meta = customSalmon.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.BOLD + "Floaty Fish");
            meta.setLore(Arrays.asList(ChatColor.ITALIC + "La Salmon de le Float"));

            // Add a custom tag using PersistentDataContainer
            NamespacedKey key = new NamespacedKey(this, "CustomTag");
            meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);

            meta.addEnchant(Enchantment.LUCK, 1, true);

            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            customSalmon.setItemMeta(meta);
        }

        // Create the smelting recipe
        createSmeltingRecipe(customSalmon);
    }

    private void createSmeltingRecipe(ItemStack result) {
        // Define the smelting recipe
        FurnaceRecipe recipe = new FurnaceRecipe(new NamespacedKey(this, "custom_smelting"),
                result, Material.COOKED_SALMON, 0.35f, 200);

        // Register the recipe
        getServer().addRecipe(recipe);
    }

    @Override
    public void onEnable() {
        giveitemcommands dumbShitCommand = new giveitemcommands(this);
        getCommand("dumbshit").setExecutor(dumbShitCommand);
        getCommand("dumbshit").setTabCompleter(new commandTabcompleter());

        getServer().getPluginManager().registerEvents(new HeldItemEffects(), this);
        getServer().getPluginManager().registerEvents(new detection(), this);
        getLogger().info("WizardShit has been enabled!");

        CopperBolt(new NamespacedKey(this, "copper_bolt"));
        SugerSped(new NamespacedKey(this, "sugar_speed"));
        ViemtneseToaster(new NamespacedKey(this, "vietnamese_toaster"));
        FloatyFish(); // This already creates a unique key internally for the smelting recipe
    }


    @Override
    public void onDisable() {
        getLogger().info("WizardShit has been disabled. Bye!");
    }
}
