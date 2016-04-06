package com.realdolmen.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

// TODO Once running, use the HAL browser to test the REST API
// TODO Create a new Animal, retrieve all Animals, search for an Animal, update an existing Animal, delete an Animal
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ZooConfig.class).profiles("production").build().run(args);

    }
}
