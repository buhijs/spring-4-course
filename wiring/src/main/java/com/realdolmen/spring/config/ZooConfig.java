package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.*;
import com.realdolmen.spring.repository.FoodRepository;
import com.realdolmen.spring.repository.FoodRepositoryImpl;
import com.realdolmen.spring.service.PairiDaiza;
import com.realdolmen.spring.service.Zoo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {

    @Bean
    public Zoo zoo() {
        PairiDaiza zoo = new PairiDaiza("Pairi Daiza");
        zoo.addAnimal(new Tiger("Bengal Tiger"));
        zoo.addAnimal(new Elephant("Indian Elephant"));
        zoo.addAnimal(new Bear("Brown Bear"));
        return zoo;
    }

    // Configure the FoodRepository
    @Bean
    public FoodRepository foodRepository() {
        FoodRepositoryImpl foodRepository = new FoodRepositoryImpl();
        foodRepository.addFoodForAnimalType(Elephant.class, new VegiFood());
        foodRepository.addFoodForAnimalType(Bear.class, new MeatyFood());
        foodRepository.addFoodForAnimalType(Tiger.class, new MeatyFood());
        return foodRepository;
    }


}
