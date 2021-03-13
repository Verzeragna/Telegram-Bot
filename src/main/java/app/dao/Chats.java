package app.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Chats {

    @Value("${pine.chats}")
    public String chats;

    @Override
    public String toString() {
        String[] chatsArray = chats.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<chatsArray.length;i++){
            stringBuilder.append(chatsArray[i]);
            if (i != chatsArray.length-1){
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
