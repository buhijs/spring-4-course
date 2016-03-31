package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.qualifiers.Kibble;
import com.realdolmen.spring.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cda5732 on 13/04/2015.
 */
@Service
public class FoodDistributionServiceImpl implements FoodDistributionService {

    @Autowired
    // TODO Load the Kibble Repository
    @Kibble
    private FoodRepository foodRepository;

    @Override
    public void feedAnimalsByType(List<Animal> animals) {
        animals.stream().forEach(x -> x.feed(foodRepository.findFoodForAnimalType(x.getClass())));
    }
}
