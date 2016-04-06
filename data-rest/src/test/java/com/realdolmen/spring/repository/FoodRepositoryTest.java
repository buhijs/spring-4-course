package com.realdolmen.spring.repository;

import com.realdolmen.spring.ZooConfig;
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
        Food food = foodRepository.findOne(1);
        assertEquals("Salmon", food.getName());
        assertEquals(208, food.getCalories());
        assertEquals(MeatyFood.Type.fish, ((MeatyFood) food).getType());
    }

    @Test
    public void findAll() throws Exception {
        assertEquals(7, foodRepository.findAll().size());
    }

    @Test
    public void remove() throws Exception {
        long start = countAllFood();
        foodRepository.delete(foodRepository.findOne(1));
        assertEquals(start - 1, countAllFood());
    }

    private long countAllFood() {
        return foodRepository.count();
    }
}
