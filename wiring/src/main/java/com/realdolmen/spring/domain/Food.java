package com.realdolmen.spring.domain;

/**
 * Created by NQRAZ66 on 30/03/2016.
 */
public abstract class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
