package com.realdolmen.spring.domain;

import javax.persistence.*;

@Entity
@Table(name = "animal_diet")
public class DietEntry {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Food food;

    @Enumerated(EnumType.STRING)
    @Column(name = "animal_type")
    Animal.Type animalType;

    public DietEntry() {
    }

    public DietEntry(Food food, Animal.Type animalType) {
        setFood(food);
        this.animalType = animalType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        food.dietEntries.add(this);
        this.food = food;
    }

    public Animal.Type getAnimalType() {
        return animalType;
    }

    public void setAnimalType(Animal.Type animalType) {
        this.animalType = animalType;
    }
}
