package me.sewer.guilds.module.impl;

import com.google.common.collect.Multimap;
import me.sewer.guilds.options.CreateOptions;
import me.sewer.guilds.guild.event.GuildCreateEvent;
import me.sewer.guilds.module.Module;
import me.sewer.guilds.module.ModuleInfo;
import me.sewer.guilds.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

@ModuleInfo(name = "RequiredItemsModule")
public class RequiredItemsModule extends Module {

    private final Multimap<String, ItemStack> requiredItems;

    public RequiredItemsModule(CreateOptions options) {
        this.requiredItems = options.requiredItems();
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onCreate(GuildCreateEvent event) {
        User user = event.getCreator();
        user.getBukkit().ifPresent(player -> {
            if (player.hasPermission("guilds.items.skip")) {
                return;
            }

            this.requiredItems.keySet().forEach(permissions -> {
                if (player.hasPermission(permissions)) {
                    Collection<ItemStack> requiredItems = this.requiredItems.get(permissions);
                    for (ItemStack requiredItem : requiredItems) {
                        if (!player.getInventory().containsAtLeast(requiredItem, requiredItem.getAmount())) {
                            user.sendMessage("notEnoughItems", requiredItem.getType().toString(), requiredItem.getAmount());
                            event.setCancelled(true);
                        }
                    }
                }
            });
        });
    }
}