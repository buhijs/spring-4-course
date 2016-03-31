package com.realdolmen.spring;

import com.realdolmen.spring.service.PairiDaiza;
import com.realdolmen.spring.service.Zoo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ApplicationConfiguration.class).profiles("production").run();
        Zoo zoo = context.getBean(Zoo.class);
        System.out.println("Zoo name: " + zoo.getName());
        System.out.println("Nr. of Animals: " + zoo.countAnimals());
        System.out.println("Max Animals: " + zoo.getMaxAnimalCount());
        System.out.println("Owner: " + zoo.getOwnerName());
        System.out.println("Ticket Price: " + zoo.getTicketPrice());
        zoo.feedAnimals();
    }
}
