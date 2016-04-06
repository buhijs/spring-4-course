package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PairiDaiza implements Zoo {
    private String name;
    private List<Animal> animals = new ArrayList<>();

    // fetch the FoodDistributionService
    @Autowired
    private FoodDistributionService foodDistributionService;

    public PairiDaiza(String name) {
        this.name = name;
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void releaseAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public boolean accept(Visitor visitor) {
        System.out.println("Welcome visitor to " + getName());
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int countAnimals() {
        return animals.size();
    }

    @Override
    public void feedAnimals() {
        // Call the FoodDistributionService to feed animals
        foodDistributionService.feedAnimalsByType(this.animals);
    }


}
