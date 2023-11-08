package edu.wgu.d387_sample_code.i18n;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Service
public class DisplayMessage {
    //static ExecutorService messageExecutor=newFixedThreadPool(5);
    public String[] getWelcomeMessage(){
        String[] messageArray = new String[2];
        Properties properties = new Properties();
        //String result = null;
        //messageExecutor.execute(()-> {
        try {
            InputStream stream = new ClassPathResource
                    ("translation_en_US.properties").getInputStream();
            properties.load(stream);
            messageArray[0] = properties.getProperty("welcome");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //});
        //messageExecutor.execute(()-> {
        try {
            InputStream stream = new
                    ClassPathResource("translation_fr_CA.properties").getInputStream();
            properties.load(stream);
            messageArray[1] = properties.getProperty("welcome");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //});
        //System.out.println(messageArray[0] + messageArray[1]);
        return messageArray;
        //return "End of DisplayMessage";
    }
}
