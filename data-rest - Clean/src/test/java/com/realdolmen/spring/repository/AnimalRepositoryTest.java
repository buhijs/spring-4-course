package com.realdolmen.spring.repository;

import com.realdolmen.spring.ZooConfig;
import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.repository.AnimalRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ZooConfig.class)
@ActiveProfiles("test")
@Transactional
public class AnimalRepositoryTest {
    @Autowired
    private AnimalRepository animalRepository;

    @Test
    public void findAll() throws Exception {
        assertEquals(3, animalRepository.findAll().size());
    }

    @Test
    public void findById() throws Exception {
        Animal animal = animalRepository.findOne(1);
        assertEquals(1, animal.getId().intValue());
        assertEquals("Tigger", animal.getName());
        assertEquals(Animal.Type.tiger, animal.getType());
        assertEquals("T-58", animal.getTag());
        assertEquals(5, animal.getAge());
    }

    @Test
    public void create() throws Exception {
        long start = countAnimals();
        Animal piglet = new Animal("Piglet", Animal.Type.pig, 2, "P-1");
        animalRepository.save(piglet);
        assertNotNull(piglet.getId());
        assertEquals(start + 1, countAnimals());
    }

    @Test
    public void remove() throws Exception {
        long before = countAnimals();
        animalRepository.delete(animalRepository.findOne(1));
        assertEquals(before - 1, countAnimals());
    }

    @Test
    public void update() throws Exception {
        Animal animal = animalRepository.findOne(2);
        animal.setName("Winnie-The-Pooh");
        animalRepository.save(animal);
        assertEquals("Winnie-The-Pooh", animalRepository.findOne(animal.getId()).getName());
    }

    private long countAnimals() {
        return animalRepository.count();
    }
}
