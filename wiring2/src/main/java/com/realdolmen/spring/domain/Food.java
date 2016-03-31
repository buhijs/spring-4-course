package com.realdolmen.spring.domain;

/**
 * Created by cda5732 on 13/04/2015.
 */
public abstract class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
