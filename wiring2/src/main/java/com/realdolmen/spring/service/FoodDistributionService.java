package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;

import java.util.List;

public interface FoodDistributionService {
    void feedAnimalsByType(List<Animal> animals);
}
