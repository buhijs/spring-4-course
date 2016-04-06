package com.realdolmen.spring.repository;

import com.realdolmen.spring.ZooConfig;
import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.DietEntry;
import com.realdolmen.spring.repository.DietEntryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by cda5732 on 30/09/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ZooConfig.class)
@ActiveProfiles("test")
@Transactional
public class DietEntryRepositoryTest {

    @Autowired
    private DietEntryRepository dietEntryRepository;

    @Test
    public void findFoodForAnimalType() throws Exception {
        List<DietEntry> foods = dietEntryRepository.findDietEntryByAnimalType(Animal.Type.donkey);
        assertEquals(3, foods.size());
        assertEquals("Apple", foods.get(0).getFood().getName());
        assertEquals("Carrot", foods.get(1).getFood().getName());
        assertEquals("Banana", foods.get(2).getFood().getName());
    }
}
