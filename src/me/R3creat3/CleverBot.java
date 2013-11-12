package me.R3creat3;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings ("rawtypes")
public class CleverBot extends ListenerAdapter {

    private ChatterBotFactory factory;
    private ChatterBot cleverbot;
    private ChatterBotSession botsession;

    public CleverBot() throws Exception {
        factory = new ChatterBotFactory();
        cleverbot = factory.create(ChatterBotType.CLEVERBOT);
        botsession = cleverbot.createSession();
    }

    public void onMessage(MessageEvent event) throws Exception {
        String message = event.getMessage();
        String[] ArrSay = message.split(" ");
        String outsay = "";

        for (int i = 1; i < ArrSay.length; i++) {
            outsay += ArrSay[i];

        }
        if (event.getMessage().startsWith(DynaBot.bot.getNick() + ": ") ||
                event.getMessage().startsWith(DynaBot.bot.getNick() + ", ")) {
            try {
                String s = botsession.think(outsay);
                event.respond(s);
            } catch (Exception e) {
                event.respond("There was an error thinking about your statement.");
            }

        }

    }
}
