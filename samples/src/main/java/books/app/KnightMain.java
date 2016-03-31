package books.app;

import books.config.KnightConfig;
import books.knights.Knight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * KnightMain application using Spring Boot.
 * Serves as a starter for examples.
 * Created by cda5732 on 18/03/2015.
 */
@SpringBootApplication
public class KnightMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KnightConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}

