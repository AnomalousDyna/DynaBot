package me.R3creat3.commands;

import me.R3creat3.R3Bot;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class SayCommand extends ListenerAdapter {

    public void onMessage(MessageEvent event) {
        if (event.getMessage().split(" ").length > 1) {

            if (event.getUser().getNick().equals("R3creat3")) {

                String message = event.getMessage();
                String channel = event.getMessage().split(" ")[1];
                String[] ArrSay = message.split(" ");
                String outsay = "";

                if (event.getMessage().startsWith("`say ")
                        && event.getMessage().contains(channel)
                        && event.getMessage().contains(message)) {
                    if (ArrSay.length > 2) {

                        for (int i = 2; i < ArrSay.length; i++) {
                            outsay += ArrSay[i];
                            if (i != ArrSay.length - 1) {
                                outsay += " ";
                            }
                        }
                    }

                    R3Bot.bot.sendMessage(channel, outsay);

                }
            }

        }
    }
}