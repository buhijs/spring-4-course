package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.DietEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DietEntryRepository extends JpaRepository<DietEntry, Integer> {
    List<DietEntry> findDietEntryByAnimalType(@Param("animalType") Animal.Type animalType);
}
