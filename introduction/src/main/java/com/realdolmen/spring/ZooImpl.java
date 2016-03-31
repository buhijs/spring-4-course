package com.realdolmen.spring;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;
import com.realdolmen.spring.service.Zoo;

import java.util.ArrayList;
import java.util.List;

public class ZooImpl implements Zoo{

    private List<Animal> animals;
    private List<Visitor> visitors;
    private String name;

    public ZooImpl(List<Animal> animals) {
        this();
        this.animals = animals;
    }

    public ZooImpl(String name) {
        this();
        this.name = name;
    }

    public ZooImpl() {
        this.animals = new ArrayList<>();
        this.visitors = new ArrayList<>();
    }

    @Override
    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    @Override
    public void releaseAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public boolean accept(Visitor visitor) {
        return this.visitors.add(visitor);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int countAnimals() {
        return this.animals.size();
    }

    @Override
    public int countVisitors() {
        return this.visitors.size();
    }
}
