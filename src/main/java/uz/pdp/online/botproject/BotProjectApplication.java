package uz.pdp.online.botproject;


import io.github.reflectframework.reflecttelegrambot.annotations.EnableBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableBot
@EnableFeignClients
@SpringBootApplication
public class BotProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotProjectApplication.class, args);
    }

}
