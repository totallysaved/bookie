package me.totallysaved.Bookie;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Bookie extends JavaPlugin{

	public static Bookie plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public final ServerChatPlayerListener playerListener = new ServerChatPlayerListener(this);
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile =this.getDescription();
		this.logger.info(pdfFile.getName()+" is now disabled");
	}
	@Override
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.playerListener, this);
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled.");
		getCommand("bet").setExecutor(new CommandExecutor() {
			@Override
			public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args){
				if (args.length > 0){
					return false;
				}
				
				if (cs instanceof Player){
					Player player = (Player)cs;
					
				} else{
					cs.sendMessage(ChatColor.RED + "What are you doing");
				}
				return true;
			}



		});
		
		
	}
}
