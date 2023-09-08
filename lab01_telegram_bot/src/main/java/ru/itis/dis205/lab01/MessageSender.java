package ru.itis.dis205.lab01;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.logging.Logger;

public class MessageSender implements Runnable {

    private Logger logger = Logger.getLogger("ru.itis.dis205.lab01.MessageSender");

    private Message message;
    private Long who;
    private TelegramLongPollingBot bot;

    public MessageSender(Message message, TelegramLongPollingBot bot) {
        this.who = message.getChatId();
        this.bot = bot;
        this.message = message;
    }

    @Override
    public void run() {

        if (message.getDocument() != null) {
            System.out.println(message.getDocument().getFileName());
            ;
        }

        if (message.isCommand()) {
            System.out.println(message.getText() + " is command");
            logger.info(message.getText() + " is command");

            if (message.getText().equals("/cmd")) {}
        }

        System.out.println(Thread.currentThread().threadId() + "," +
                message.getText() + ", " +
                message.getFrom().getUserName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (message.getText() != null)
            sendText(who, message.getText(), bot);
    }


    public void sendText(Long who, String what, TelegramLongPollingBot bot){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            bot.execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }
}
