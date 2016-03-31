package com.realdolmen.spring;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.MeatyFood;
import com.realdolmen.spring.repository.FoodRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ZooConfig.class)
@ActiveProfiles("test")
@Transactional
public class FoodRepositoryTest {
    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void findById() throws Exception {
        Food food = foodRepository.findFoodById(1);
        assertEquals("Salmon", food.getName());
        assertEquals(208, food.getCalories());
        assertEquals(MeatyFood.Type.fish, ((MeatyFood) food).getType());
    }

    @Test
    public void findAll() throws Exception {
        assertEquals(7, countAllFood());
    }

    @Test
    public void remove() throws Exception {
        int start = countAllFood();
        foodRepository.removeFood(foodRepository.findFoodById(1));
        assertEquals(start - 1, countAllFood());
    }

    @Test
    public void findFoodForAnimalType() throws Exception {
        List<Food> foods = foodRepository.findFoodForAnimalType(Animal.Type.donkey);
        assertEquals(3, foods.size());
        assertEquals("Apple", foods.get(0).getName());
        assertEquals("Carrot", foods.get(1).getName());
        assertEquals("Salmon", foods.get(2).getName());
    }

    private int countAllFood() {
        return foodRepository.findAllFood().size();
    }
}
