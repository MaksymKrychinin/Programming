package com.bot.telegram.telegram_bot;


import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

public class DBUsers {
    private List<Message> messageList= new ArrayList<>();
    private static DBUsers instance = new DBUsers();

    public List<Message> getMessageList() {
        return messageList;
    }

    private DBUsers() {
    }

    public static DBUsers getInstance() {
        if (instance == null){
            instance = new DBUsers();
        }
        return instance;
    }
}
