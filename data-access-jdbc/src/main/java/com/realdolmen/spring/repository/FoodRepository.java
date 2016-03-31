package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.MeatyFood;
import com.realdolmen.spring.domain.VegiFood;

import java.util.List;

public interface FoodRepository {
    Food findFoodById(int id);
    List<Food> findAllFood();
    List<Food> findFoodForAnimalType(Animal.Type type);
    void addFoodForAnimalType(Animal.Type animalType, Food food);
    void removeFood(Food food);
}
