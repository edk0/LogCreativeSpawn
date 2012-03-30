package uk.co.edk141.logspawning;

import java.util.logging.Logger;
import org.bukkit.Material;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class LCS extends JavaPlugin implements Listener {
    public static final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        new LogNetServerHandler(this, ((CraftPlayer)event.getPlayer()).getHandle().netServerHandler);
    }
    
    public void onCreativeSpawn(Player player, ItemStack item, int slot) {
        if (item.getType() == Material.AIR) return;
        log.info(String.format("%s:[LCS] %s:%d * %d in slot %d", player.getName(), item.getType().name(), item.getDurability(), item.getAmount(), slot));
    }
}
