package me.R3creat3.commands;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.*;

import me.R3creat3.R3Bot;

@SuppressWarnings("rawtypes")
public class JoinCommand extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {
        if (event.getMessage().split(" ").length > 1) {

            if (event.getMessage().equals("`join")) {

                event.respond("Usage: `join <channel>");
            }

            String channelarg = event.getMessage().split(" ")[1];
            if (event.getMessage().startsWith("`join ") && event.getMessage().contains(channelarg)) {

                if (event.getUser().getNick().equals("R3creat3")){
                    R3Bot.bot.sendRawLineNow("join" + " " + channelarg);

                    event.respond("Gonna try join channel " + channelarg + ", OK?");

                }
            }
        }

    }
}