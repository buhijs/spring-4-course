package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;

public interface FoodRepository {
    void addFoodForAnimalType(Class<? extends Animal> c, Food food);

    Food findFoodForAnimalType(Class<? extends Animal> c);
}
