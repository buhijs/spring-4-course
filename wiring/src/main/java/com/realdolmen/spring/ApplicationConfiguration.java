package com.realdolmen.spring;

import com.realdolmen.spring.service.Zoo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfiguration.class);
        Zoo zoo = context.getBean(Zoo.class);
        System.out.println(zoo.getName());
        System.out.println("Nr. of Animals: " + zoo.countAnimals());

        // call the method to feed the animals
        zoo.feedAnimals();

    }
}
