package app.component.bot;

import app.service.MessageHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class PineBot extends TelegramWebhookBot {

    private static final Logger log = Logger.getLogger(PineBot.class);

    private MessageHandler messageHandler;

    @Value("${telegrambot.userName}")
    private String userName;

    @Value("${telegrambot.botToken}")
    private String token;

    @Value("${telegrambot.webHookPath}")
    private String botPath;

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        log.info("WebhookUpdateReceived message");
//        try {
//            execute(messageHandler.incomingMessage(update));
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
        return messageHandler.incomingMessage(update);
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotPath() {
        return botPath;
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }
}
