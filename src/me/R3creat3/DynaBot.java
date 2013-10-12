package me.R3creat3;

import me.R3creat3.commands.JoinCommand;
import me.R3creat3.commands.PartCommand;
import me.R3creat3.commands.SayCommand;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import java.io.IOException;
import java.util.logging.Logger;

public class DynaBot {

    public static PircBotX bot = new PircBotX();
    public final static Logger logger = Logger.getLogger("R3Bot");

    public static void main(String args[]) {

        bot.setAutoNickChange(true);
        bot.setVersion("Dyna IRC bot");
        bot.setLogin("DynaBot");
        bot.setName("DynaBot");
        bot.identify("BADBOY2000");
        bot.setVerbose(true);
        try {
            bot.connect("irc.freenode.net", 6667);
        } catch (IOException e) {
        } catch (IrcException e) {

        }
        bot.setMessageDelay(1000);
        bot.setAutoReconnect(true);
        bot.setAutoReconnectChannels(true);
        bot.joinChannel("#R3creat3");

        bot.getListenerManager().addListener(new JoinCommand());
        bot.getListenerManager().addListener(new PartCommand());
        bot.getListenerManager().addListener(new SayCommand());
        try {
            bot.getListenerManager().addListener(new CleverBot());
        } catch (Exception e) {

        }
    }

}
