package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.repository.AnimalRepository;
import com.realdolmen.spring.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FoodDistributionServiceImpl implements FoodDistributionService {

    @Autowired(required = false)
    private FoodRepository foodRepository;

    @Autowired(required = false)
    private AnimalRepository animalRepository;

    @Override
    public void feedAllAnimal() {
        Objects.requireNonNull(animalRepository, "Animal repository must exist");
        Objects.requireNonNull(foodRepository, "Food repository must exist");

        animalRepository.findAll().stream().forEach(animal -> {
            List<Food> allFoodsForAnimal = foodRepository.findFoodForAnimalType(animal.getType());
            if(allFoodsForAnimal != null && allFoodsForAnimal.isEmpty()) {
                class StarvingAnimalException extends IllegalStateException {
                    public StarvingAnimalException(String message) { super(message); }
                }
                throw new StarvingAnimalException("Oh dear, there is no food for '" + animal.getName() + "'");
            }
            Food food = allFoodsForAnimal.get((int) (Math.random() * allFoodsForAnimal.size()));
            animal.feed(food);
        });
    }
}
