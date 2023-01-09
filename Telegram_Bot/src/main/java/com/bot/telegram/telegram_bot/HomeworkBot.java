package com.bot.telegram.telegram_bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

@Component
public class HomeworkBot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    String token;
    @Value("${bot.name}")
    String name;
    @Value("${bot.admin.chat_id}")
    long id;

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            DBUsers dbUsers = DBUsers.getInstance();
            if (update.getMessage().getText() != null && update.getMessage().getText().equals("get")) {
                try {
                    SendMessage sendMessage;
                    SendDocument sendDocument;
                    for (Message i : dbUsers.getMessageList()) {
                        if (i.getText() != null) {
                            sendMessage = new SendMessage();
                            sendMessage.setChatId(update.getMessage().getChatId());
                            sendMessage.setText(i.getText());
                            execute(sendMessage);
                        }
                        if (i.getDocument() != null) {
                            String filename = i.getDocument().getFileName();
                            String fileId = i.getDocument().getFileId();
                            GetFile getFile = new GetFile();
                            getFile.setFileId(fileId);
                            String filePath = execute(getFile).getFilePath();
                            File file = downloadFile(filePath);
                            file = new File(file.getParent(), filename);
                            sendDocument = new SendDocument();
                            sendDocument.setDocument(new InputFile(file));
                            sendDocument.setChatId(update.getMessage().getChatId());
                            execute(sendDocument);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                dbUsers.getMessageList().add(update.getMessage());
            }
        }

    }


}

