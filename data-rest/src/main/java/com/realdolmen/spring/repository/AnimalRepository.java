package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
