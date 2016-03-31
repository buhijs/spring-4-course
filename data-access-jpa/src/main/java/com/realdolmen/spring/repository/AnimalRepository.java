package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;

import java.util.List;

public interface AnimalRepository {
    void create(Animal animal);
    Animal findById(int id);
    List<Animal> findAll();
    void update(Animal animal);
    void remove(Animal animal);
}
