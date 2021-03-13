package app.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.IOException;

@Service
public class Weather {

    @Value("${weather.link}")
    private String weatherLink;
    @Value("${weather.night}")
    private String tNight;
    @Value("${weather.day}")
    private String tDay;
    @Value("${weather.source}")
    private String source;
    @Value("${weather.get.error}")
    private String error;

    public SendMessage getWeather(){
        StringBuilder weather = new StringBuilder();
        SendMessage message = new SendMessage();
        try {
            Document doc = Jsoup.connect(weatherLink).get();
            //Погода сегодня
            Elements todayElements = doc.getElementsByClass("tab  tooltip");
            String[] title = todayElements.get(0).text().split(" ");
            Elements temperature = todayElements.get(0).getElementsByClass("unit unit_temperature_c");
            String[] strTemperature = temperature.text().split(" ");
            weather.append(title[3]).append(": ").append(title[0]).append(title[1]).append(" ")
                    .append(title[2])
                    .append(". ").append(todayElements.get(0).attr("data-text")).append(".")
                    .append("\n");
            weather.append(tNight).append(" ").append(strTemperature[0])
                    .append(", ").append(tDay).append(" ").append(strTemperature[1]).append(".").append("\n");

            //Погода завтра
            Elements tomorrowElements = doc.getElementsByClass("nolink tab tablink tooltip");
            title = tomorrowElements.get(0).text().split(" ");
            temperature = tomorrowElements.get(0).getElementsByClass("unit unit_temperature_c");
            strTemperature = temperature.text().split(" ");
            weather.append(title[3]).append(": ").append(title[0]).append(title[1]).append(" ")
                    .append(title[2])
                    .append(". ").append(todayElements.get(0).attr("data-text")).append(".")
                    .append("\n");
            weather.append(tNight).append(" ").append(strTemperature[0])
                    .append(", ").append(tDay).append(" ").append(strTemperature[1]).append(".").append("\n")
                    .append(source).append(".");
            System.out.println(weather.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (weather.length()==0){
            return message.setText(error);
        }
        return message.setText(weather.toString());
    }
}
