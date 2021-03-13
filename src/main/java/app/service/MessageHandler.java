package app.service;

import app.component.welcome.Welcome;
import app.config.AppConfig;
import app.dao.Bus;
import app.dao.Chats;
import app.dao.Services;
import app.dao.Uk;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageHandler {

    private static final Logger log = Logger.getLogger(MessageHandler.class);
    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

    @Autowired
    MessageSource messageSource;

    @Autowired
    Weather weather;

    public SendMessage incomingMessage(Update update){
        log.info("MessageHandler received message");
        SendMessage replyMessage = null;
        if (update==null){
            replyMessage = errorMessage().setChatId(update.getMessage().getChatId());
            return replyMessage;
        }
        switch (update.getMessage().getText()){
            case "/start":
                replyMessage = startMessage().setChatId(update.getMessage().getChatId());
                break;
            case "/bus":
                replyMessage = busMessage().setChatId(update.getMessage().getChatId());
                break;
            case "/service":
                replyMessage = serviceMessage().setChatId(update.getMessage().getChatId());
                break;
            case "/uk":
                replyMessage = ukMessage().setChatId(update.getMessage().getChatId());
                break;
            case "/chats":
                replyMessage = chatsMessage().setChatId(update.getMessage().getChatId());
                break;
            case "/weather":
                replyMessage = weather.getWeather().setChatId(update.getMessage().getChatId());
                break;
            default:
                replyMessage = errorMessage().setChatId(update.getMessage().getChatId());
                break;
        }

        return replyMessage;
    }

    private SendMessage startMessage(){
        Welcome welcome = ctx.getBean("welcomeBean", Welcome.class);
        SendMessage startMessage = new SendMessage();
        startMessage.setText(welcome.toString());
        return startMessage;
    }

    private SendMessage busMessage(){
       Bus bus = ctx.getBean("busBean", Bus.class);
       SendMessage busMessage = new SendMessage();
       busMessage.setText(bus.toString());
       return busMessage;
    }

    private SendMessage serviceMessage(){
        Services services = ctx.getBean("servicesBean", Services.class);
        SendMessage serviceMessage = new SendMessage();
        serviceMessage.setText(services.link);
        return serviceMessage;
    }

    private SendMessage ukMessage(){
        Uk uk = ctx.getBean("ukBean", Uk.class);
        SendMessage ukMessage = new SendMessage();
        ukMessage.setText(uk.toString());
        return ukMessage;
    }

    private SendMessage chatsMessage(){
        Chats chats = ctx.getBean("chatsBean",Chats.class);
        SendMessage chatsMessage = new SendMessage();
        chatsMessage.setText(chats.toString());
        return chatsMessage;
    }

    private SendMessage errorMessage(){
        SendMessage errorMessage = new SendMessage();
        errorMessage.setText("Я такой команды не заню(");
        return errorMessage;
    }

}
