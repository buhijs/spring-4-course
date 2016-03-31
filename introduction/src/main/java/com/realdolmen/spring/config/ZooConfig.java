package com.realdolmen.spring.config;

import com.realdolmen.spring.ZooImpl;
import com.realdolmen.spring.domain.Bear;
import com.realdolmen.spring.domain.Elephant;
import com.realdolmen.spring.domain.Tiger;
import com.realdolmen.spring.domain.Visitor;
import com.realdolmen.spring.service.Zoo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {

    @Bean
    public Zoo zoo() {
        Zoo zoo = new ZooImpl("Planckendael");
        zoo.addAnimal(new Tiger());
        zoo.addAnimal(new Bear());
        zoo.addAnimal(new Bear());
        zoo.addAnimal(new Elephant());
        zoo.addAnimal(new Elephant());
        zoo.addAnimal(new Elephant());
        zoo.addAnimal(new Elephant());

        zoo.accept(new Visitor());
        zoo.accept(new Visitor());
        zoo.accept(new Visitor());
        zoo.accept(new Visitor());
        return zoo;
    }
}
