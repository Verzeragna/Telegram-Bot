package app.dao;

import org.springframework.beans.factory.annotation.Value;

public class Services {

    @Value("${service.link}")
    public String link;

}
