package app.controller;

import app.component.bot.PineBot;
import app.config.AppConfig;
import app.service.MessageHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class BotController {

    private static final Logger log = Logger.getLogger(BotController.class);

    @Autowired
    MessageHandler messageHandler;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BotApiMethod<?> onReceive(@RequestBody Update update) {
        log.info("Incoming message " + update.getMessage().getText());
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        PineBot pineBot = ctx.getBean("pineBotBean", PineBot.class);
        pineBot.setMessageHandler(messageHandler);
        return pineBot.onWebhookUpdateReceived(update);
    }


}
