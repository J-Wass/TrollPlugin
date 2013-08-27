package stuff.LeChosenOne.Troll;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class Troll extends JavaPlugin
{
    public static Troll plugin;
    public static final Logger logger = Logger.getLogger("Minecraft");
    @Override
    public void onDisable()
    {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been DISABLED.");
    }
    @Override
    public void onEnable()
    {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been ENABLED.");
    }
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = (Player) sender;
        if(commandLabel.equalsIgnoreCase("Curse"))
        {
            if(args.length == 0)
            {
               player.sendMessage(ChatColor.RED + "Please input a target.");
            }
            else if(args.length == 1)
            {
                Player target = player.getServer().getPlayer(args[0]);
                target.setHealth(1);
                player.sendMessage(ChatColor.RED + "Target successfully cursed.");
            }    
            return true;
        }
        else if(commandLabel.equalsIgnoreCase("Fish"))
        {
            if(args.length == 0)
            {
                player.sendMessage(ChatColor.RED + "Please input a target.");
            }
            else if(args.length == 1)
            {
                Player target = player.getServer().getPlayer(args[0]);
                PlayerInventory inv = target.getInventory();
                ItemStack fish = new ItemStack(Material.RAW_FISH, 64);
                target.setItemInHand(fish);
                inv.addItem(fish);
                player.sendMessage(ChatColor.RED + "Target successfully fish spammed.");
            }
            return true;
        }
        else if(commandLabel.equalsIgnoreCase("Ignite"))
        {
            if(args.length == 0)
            {
                player.sendMessage(ChatColor.RED + "Please input a target.");
            }
            else if(args.length == 1)
            {
                Player target = player.getServer().getPlayer(args[0]);
                target.setFireTicks(1);
                 player.sendMessage(ChatColor.RED + "Target successfully ignited.");
            }
            return true;
        }
        else if(commandLabel.equalsIgnoreCase("Starve"))
        {
            if(args.length == 0)
            {
                player.sendMessage(ChatColor.RED + "Please input a target.");
            }
            else if(args.length == 1)
            {
                Player target = player.getServer().getPlayer(args[0]);
                target.setFoodLevel(0);
                player.sendMessage(ChatColor.RED + "Target successfully starved.");
            }
            return true;
        }      
        return false;

    }
    
}
