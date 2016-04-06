package com.realdolmen.spring.domain;

import javax.persistence.Entity;

@Entity
public class VegiFood extends Food {
    private boolean fruit;
    private boolean vegetables;

    public VegiFood() {
    }

    public VegiFood(int id, String name, int calories, boolean fruit, boolean vegetables) {
        super(id, name, calories);
        this.fruit = fruit;
        this.vegetables = vegetables;
    }

    public boolean isFruit() {
        return fruit;
    }

    public void setFruit(boolean fruit) {
        this.fruit = fruit;
    }

    public boolean isVegetables() {
        return vegetables;
    }

    public void setVegetables(boolean vegetables) {
        this.vegetables = vegetables;
    }
}
