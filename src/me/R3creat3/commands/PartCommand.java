package me.R3creat3.commands;

import me.R3creat3.R3Bot;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class PartCommand extends ListenerAdapter {

    public void onMessage(MessageEvent event) throws Exception {
        if (event.getMessage().split(" ").length > 1) {

            String channel = event.getMessage().split(" ")[1];
            if (event.getMessage().startsWith("`part ") && event.getMessage().contains(channel)) {
                if (event.getUser().getNick().equals("R3creat3")) {

                    event.respond("OK! Will leave channel " + channel + "!");
                    R3Bot.bot.sendRawLineNow("part" + " " + channel);
                }

            }

        }
    }
}