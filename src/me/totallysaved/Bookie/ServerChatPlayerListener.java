package me.totallysaved.Bookie;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ServerChatPlayerListener implements Listener {
	
	public static Bookie plugin;
	
	public ServerChatPlayerListener(Bookie instance){
		plugin = instance;
	}
	@EventHandler
	public void onPlayerChat(PlayerChatEvent chat){
		Player p = chat.getPlayer();
		String message = chat.getMessage();
		String message_lower = message.toLowerCase();
		ChatColor RED = ChatColor.RED;
		ChatColor WHITE = ChatColor.WHITE;
		if(message_lower.contains("hi") && message_lower.contains("server")) {
			p.sendMessage(RED + "[Server] " + WHITE + "Hello " + p.getName());
			chat.setCancelled(true);
		}
	}
}
