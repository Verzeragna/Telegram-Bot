package app.component.welcome;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Welcome {

    @Value("${welcome.bus}")
    String bus;
    @Value("${welcome.service}")
    String service;
    @Value("${welcome.uk}")
    String uk;
    @Value("${welcome.chats}")
    String chats;
    @Value("${welcome.weather}")
    String weather;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bus).append("\n")
                .append(service).append("\n")
                .append(uk).append("\n")
                .append(chats).append("\n")
                .append(weather);
        return stringBuilder.toString();
    }
}
