package app.config;

import app.component.welcome.Welcome;
import app.dao.Bus;
import app.component.bot.PineBot;
import app.dao.Chats;
import app.dao.Services;
import app.dao.Uk;
import org.springframework.context.annotation.*;

import javax.management.MXBean;

@Configuration
@ComponentScan("app.component")
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource(value = "classpath:messages_ru_RU.properties",encoding = "Windows-1251")})
public class AppConfig {

    @Bean("pineBotBean")
    public PineBot getPineBotBean(){
        return new PineBot();
    }

    @Bean("busBean")
    public Bus getBusBean(){
        return new Bus();
    }

    @Bean("ukBean")
    public Uk getUkBean(){
        return new Uk();
    }

    @Bean("servicesBean")
    public Services getService(){
        return new Services();
    }

    @Bean("chatsBean")
    public Chats getChats(){
        return new Chats();
    }

    @Bean("welcomeBean")
    public Welcome getWelcome(){
        return new Welcome();
    }

}
