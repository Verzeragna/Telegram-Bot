package app.service;

import app.controller.BotController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class Ping {

    private static final Logger log = Logger.getLogger(BotController.class);

    @Value("${ping.url}")
    private String pingUrl;

    @Scheduled(fixedRateString = "${ping.period}")
    public void pingMe() {
        try {
            URL url = new URL(pingUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            log.info("Ping to google" + url.getHost() + connection.getResponseCode());
            connection.disconnect();
        } catch (IOException e) {
            log.error("Ping FAILED");
            e.printStackTrace();
        }

    }
}
