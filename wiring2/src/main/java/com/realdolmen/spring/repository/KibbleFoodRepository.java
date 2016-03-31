package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.qualifiers.Kibble;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class KibbleFoodRepository implements FoodRepository {


    private Map<String, Food> feed = new HashMap<>();

    @Override
    public void addFoodForAnimalType(Class<? extends Animal> c, Food food) {
        feed.put(c.getName(), food);
    }

    @Override
    public Food findFoodForAnimalType(Class<? extends Animal> c) {
        return feed.get(c.getName());
    }
}
