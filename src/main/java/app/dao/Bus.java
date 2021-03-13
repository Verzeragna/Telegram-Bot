package app.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bus {

    @Value("${bus.title.fromCenter}")
    public String titleFromCenter;
    @Value("${bus.info.fromCenter}")
    public String infoFromCenter;
    @Value("${bus.title.fromPine}")
    public String titleFromPine;
    @Value("${bus.info.fromPine}")
    public String infoFromPine;
    @Value("${bus.phone}")
    public String phone;
    @Value("${bus.hunt}")
    public String hunt;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(titleFromCenter)
                .append("\n")
                .append(infoFromCenter)
                .append("\n")
                .append(titleFromPine)
                .append("\n")
                .append(infoFromPine)
                .append("\n")
                .append(phone)
                .append("\n")
                .append(hunt);
        return stringBuilder.toString();
    }
}
