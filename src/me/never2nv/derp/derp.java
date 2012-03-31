package me.never2nv.derp;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class derp extends JavaPlugin {
	public static derp plugin;
	public final Logger logger = Logger.getLogger("Minecraft");

	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " is now disabled.");
	}
	
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() +" version " + pdfFile.getVersion() + " is now enabled.");

	}
	
	// Blaze rod acts as a more powerful smite, on crosshair location!
				public void onPlayerInteract(PlayerInteractEvent event){
					Player player = event.getPlayer();
					int blockId = player.getItemInHand().getType().getId();
					if(blockId == 369){
						Block block = player.getTargetBlock(null, 50);
						Location location = block.getLocation();
						World world = player.getWorld();
						world.strikeLightning(location);
						world.createExplosion(location, 6);
					}
				}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		World world = player.getWorld();
		if(commandLabel.equalsIgnoreCase("derp") ){
			
			if(args.length == 0){
				Block targetblock = player.getTargetBlock(null, 50);
				Location location = targetblock.getLocation();
				world.strikeLightning(location);
				world.createExplosion(location, 2);
				getServer().broadcastMessage(player.getDisplayName() + " is furious at all the derps on the server currently!");
				getServer().broadcastMessage("He has show his true power through his rage! " + ChatColor.RED + "                                DID YOU HEAR THE ROAR?!");
		}
			else if (args.length == 1){
				if(player.getServer().getPlayer(args[0]) != null){
					Player targetplayer = player.getServer().getPlayer(args[0]);
					Location location = targetplayer.getLocation();
					world.strikeLightning(location);
					world.createExplosion(location, 2);
					player.sendMessage(ChatColor.BLUE + "Derping " + targetplayer.getDisplayName() + " and letting everyone know it.");
					getServer().broadcastMessage(ChatColor.RED + "DERP! " + ChatColor.GREEN + "The couragious derping of " + targetplayer.getDisplayName() + " is beyond comprehension!");
				}
				else {
					player.sendMessage(ChatColor.RED + "SORRY! Player is offline! >:0");
				} }
				
				else if(args.length > 1) {
					player.sendMessage(ChatColor.RED + "SORRY! Too many arguments!"); }}
		return false;
				}
				
			public boolean onCommand1(CommandSender sender, Command cmd, String commandLabel, String[] args) {
				Player player = (Player) sender;
				if(commandLabel.equalsIgnoreCase("starve") ){
					if(args.length == 0){
						//starving player hardcore parkour.
						player.setHealth(2);
						player.setFoodLevel(0);
						player.chat("/me " + ChatColor.DARK_RED + "just starved himself intentionally, they need a " + ChatColor.GREEN + "Medic!");
						player.sendMessage(ChatColor.GREEN + "MUHAHAHA...Awesome, " + ChatColor.WHITE + "You Refused To Eat In PROTEST!");
					}
					
					else if(args.length == 1){
						// Fixed internal errors, as before it didn't check IF player was online.
						if(player.getServer().getPlayer(args[0]) !=null){
						Player targetPlayer = player.getServer().getPlayer(args[0]);
						player.setHealth(2);
						player.setFoodLevel(0);
						player.chat("/me " + ChatColor.DARK_RED + "Just cutoff " + targetPlayer.getDisplayName() + "'s food supply. They need a " + ChatColor.GREEN + "Medic!");
						player.sendMessage(ChatColor.GREEN + "MUHAHAHA..., " + ChatColor.WHITE + "STARVE FOR YOUR ACTIONS, FOOL!");
					
			}
			return false;
	}
}
				return false;
			}
			
			// Global Chat Derping of player. Makes everyone in the chatroom say "What a derp!" :P
			public boolean onCommand2(CommandSender sender, Command cmd, String commandLabel, String[] args) {
				Player player = (Player) sender;
				World world = player.getWorld();
				if(commandLabel.equalsIgnoreCase("derpy") ){
					
					if(args.length == 0){
						Block targetblock = player.getTargetBlock(null, 50);
						Location location = targetblock.getLocation();
						world.strikeLightning(location);
						world.createExplosion(location, 2);
						getServer().broadcastMessage(player.getDisplayName() + " is furious at all the derps on the server currently!");
						getServer().broadcastMessage("He has show his true power through his rage! " + ChatColor.RED + "                                DID YOU HEAR THE ROAR?!");
						for(Player p : getServer().getOnlinePlayers())
						{
						    p.chat("What a derp!");
						}
						
				}
			
}
				return false;
			}
		}
	


