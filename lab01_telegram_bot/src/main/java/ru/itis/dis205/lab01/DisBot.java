package ru.itis.dis205.lab01;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisBot extends TelegramLongPollingBot {

    private ExecutorService executor = Executors.newFixedThreadPool(10);
    @Override
    public String getBotUsername() {
        return "dis205_bot";
    }

    @Override
    public String getBotToken() {
        return "6582275798:AAEYRR_x6KHiMAzGr6_dwsZODZl0aCmTrWk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        Message message = update.getMessage();
        MessageSender messageSender = new MessageSender(message, this);
        //new Thread(messageSender).start();
        executor.execute(messageSender);
    }
}
