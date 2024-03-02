package me.itzsunboi.wizardshit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;

public class HeldItemEffects implements Listener {

    @EventHandler
    public void SugarInteract(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand =  player.getInventory().getItemInMainHand(); // For off-hand, use player.getInventory().getItemInOffHand();
        ItemStack offhanditem =  player.getInventory().getItemInOffHand();
        Material helditem = player.getInventory().getItemInMainHand().getType();
        Material offhelditem = player.getInventory().getItemInOffHand().getType();
        // Check if the item in the player's hand is the specific item you're looking for
        if (helditem == Material.SUGAR && isSpecificitem(itemInHand, Material.SUGAR)) { // Sugar De Le Speed
                // Apply the effect to the player
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 10));
        } else if (offhelditem == Material.SUGAR && isSpecificitem(offhanditem, Material.SUGAR)) { // Sugar De Le Speed
            // Apply the effect to the player
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25, 10));
        }
        if (helditem == Material.SALMON && isSpecificitem(itemInHand, Material.SALMON)) { // Sugar De Le Speed
            // Apply the effect to the player
            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 25, 2));
        } else if (offhelditem == Material.SALMON && isSpecificitem(offhanditem, Material.SALMON)) { // Sugar De Le Speed
            // Apply the effect to the player
            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 25, 2));
        }
        if (helditem == Material.BOW && isSpecificitem(itemInHand, Material.BOW)) { // Sugar De Le Speed
            // Apply the effect to the player
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 25, 10));
        } else if (offhelditem == Material.BOW && isSpecificitem(offhanditem, Material.BOW)) { // Sugar De Le Speed
            // Apply the effect to the player
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 25, 10));
        }
    }


    private boolean isSpecificitem(ItemStack item, Material type) {
        if (item != null && item.getType() == type && item.hasItemMeta()) {
            // Check for specific chest characteristics (customize as needed)
            // Example: Check for a custom tag or lore
            if (item.getItemMeta().hasDisplayName()) {
                if (item.getItemMeta().hasLore()){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


}
