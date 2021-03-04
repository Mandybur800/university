package ua.mandybur.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.mandybur.university.handler.ConsoleHandler;

@SpringBootApplication
public class UniversityApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication
                .run(UniversityApplication.class, args);
        ConsoleHandler handler = new ConsoleHandler(run);
        handler.handle();
    }

}
