package app.dao;

import org.springframework.beans.factory.annotation.Value;

public class Uk {

    @Value("${uk.address}")
    public String address;
    @Value("${uk.title}")
    public String title;
    @Value("${uk.monday}")
    public String monday;
    @Value("${uk.tuesday}")
    public String tuesday;
    @Value("${uk.wednesday}")
    public String wednesday;
    @Value("${uk.thursday}")
    public String thursday;
    @Value("${uk.friday}")
    public String friday;
    @Value("${uk.phone}")
    public String phone;
    @Value("${uk.whatsapp}")
    public String whatsapp;
    @Value("${uk.commonPhone}")
    public String commonPhone;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(address)
                .append("\n")
                .append(title)
                .append("\n")
                .append(monday)
                .append("\n")
                .append(tuesday)
                .append("\n")
                .append(wednesday)
                .append("\n")
                .append(thursday)
                .append("\n")
                .append(friday)
                .append("\n")
                .append(phone)
                .append("\n")
                .append(whatsapp)
                .append("\n")
                .append(commonPhone);

        return stringBuilder.toString();
    }
}
