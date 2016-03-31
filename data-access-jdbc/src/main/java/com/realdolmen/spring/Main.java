package com.realdolmen.spring;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.MeatyFood;
import com.realdolmen.spring.domain.VegiFood;
import com.realdolmen.spring.repository.FoodRepository;
import com.realdolmen.spring.service.FoodDistributionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ZooConfig.class).profiles("production").build().run();
        FoodDistributionService foodDistributor = context.getBean(FoodDistributionService.class);
        System.out.println("**********************************");
        System.out.println("Feeding animals:");
        System.out.println("**********************************");
        foodDistributor.feedAnimalsByType(Arrays.asList(
            new Animal("Shere Khan", Animal.Type.tiger, 20, "T-214"),
            new Animal("Dumbo", Animal.Type.elephant, 5, "E-147"),
            new Animal("Xing Hui", Animal.Type.bear, 12, "B-52")
        ));
        System.out.println("**********************************");
    }
}