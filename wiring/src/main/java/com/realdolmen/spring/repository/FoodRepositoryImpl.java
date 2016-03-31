package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;

import java.util.HashMap;

public class FoodRepositoryImpl implements FoodRepository {

    private HashMap<Class<? extends Animal>, Food> foodHashMap;

    public FoodRepositoryImpl() {
        this.foodHashMap = new HashMap<>();
    }

    public FoodRepositoryImpl(HashMap<Class<? extends Animal>, Food> foodHashMap) {
        this.foodHashMap = foodHashMap;
    }

    @Override
    public void addFoodForAnimalType(Class<? extends Animal> clazz, Food food) {
        this.foodHashMap.put(clazz, food);
    }

    @Override
    public Food findFoodForAnimalTpe(Class<? extends Animal> clazz) {
        return this.foodHashMap.get(clazz);
    }
}
