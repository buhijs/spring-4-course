package com.realdolmen.spring;

import com.realdolmen.spring.domain.Animal;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // TODO: Complete the Main class to allow bootstrapping a Spring application using Spring Boot
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Main.class).build().run();
//        Animal animal = context.getBean(Animal.class);
    }
}
