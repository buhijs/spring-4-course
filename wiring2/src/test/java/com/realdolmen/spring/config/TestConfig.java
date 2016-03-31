package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.*;
import com.realdolmen.spring.domain.Kibble;
import com.realdolmen.spring.qualifiers.*;
import com.realdolmen.spring.repository.FoodRepository;
import com.realdolmen.spring.repository.FoodRepositoryImpl;
import com.realdolmen.spring.repository.KibbleFoodRepository;
import com.realdolmen.spring.service.PairiDaiza;
import com.realdolmen.spring.service.Zoo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:/test.properties")
@Profile("test")
@ComponentScan("com.realdolmen.spring")
public class TestConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Zoo zoo(@Value("${zoo.name}") String name,
                   @Value("${zoo.maxAnimalCount}") int maxAnimalCount,
                   @Value("${zoo.ownerName}") String ownerName,
                   @Value("${zoo.ticketPrice}") double ticketPrice) {
        PairiDaiza zoo = new PairiDaiza(name);
        zoo.addAnimal(new Tiger("Bengal Tiger"));
        zoo.addAnimal(new Elephant("Indian Elephant"));
        zoo.addAnimal(new Bear("Brown Bear"));
        zoo.setMaxAnimalCount(maxAnimalCount);
        zoo.setOwnerName(ownerName);
        zoo.setTicketPrice(ticketPrice);
        return zoo;
    }

    @Bean
    @NormalFood
    public FoodRepository foodRepository() {
        FoodRepository foodRepository = new FoodRepositoryImpl();
        foodRepository.addFoodForAnimalType(Tiger.class, new MeatyFood("Red Antilope Meat"));
        foodRepository.addFoodForAnimalType(Bear.class, new MeatyFood("Pink Salmon"));
        foodRepository.addFoodForAnimalType(Elephant.class, new VegiFood("Cabbage"));
        return foodRepository;
    }

    @Bean
    @com.realdolmen.spring.qualifiers.Kibble
    public FoodRepository kibbleRepository() {
        FoodRepository foodRepository = new KibbleFoodRepository();
        foodRepository.addFoodForAnimalType(Tiger.class, new com.realdolmen.spring.domain.Kibble("Kibble"));
        foodRepository.addFoodForAnimalType(Bear.class, new com.realdolmen.spring.domain.Kibble("Kibble"));
        foodRepository.addFoodForAnimalType(Elephant.class, new com.realdolmen.spring.domain.Kibble("Kibble"));
        return foodRepository;
    }

}
