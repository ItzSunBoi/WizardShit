package me.itzsunboi.wizardshit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BlockIterator;

public class detection implements Listener {

    private boolean isSpecificStick(ItemStack item) {
        if (item != null && item.getType() == Material.CARROT_ON_A_STICK && item.hasItemMeta()) {
            // Check for specific chest characteristics (customize as needed)
            // Example: Check for a custom tag or lore
            if (item.getItemMeta().hasDisplayName()) {
                String displayName = item.getItemMeta().getDisplayName();
                if (item.getItemMeta().hasLore() && displayName.equals(ChatColor.BOLD + "Copper Bolt")){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        //Check if they right-click the air or a block
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            //Get the item in their main hand
            if (player.getInventory().getItemInMainHand().getType() == Material.CARROT_ON_A_STICK) { //Change to whatever material you want
                if (isSpecificStick(item)) {
                    Block targetBlock = player.getTargetBlockExact(200);
                    if (targetBlock != null) {
                        player.getWorld().strikeLightning(targetBlock.getLocation());
                    }

                }
            }
        }
    }
}
