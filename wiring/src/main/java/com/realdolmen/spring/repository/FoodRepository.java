package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;

public interface FoodRepository {
    void addFoodForAnimalType(Class<? extends Animal> clazz, Food food);

    Food findFoodForAnimalTpe(Class<? extends Animal> clazz);
}
