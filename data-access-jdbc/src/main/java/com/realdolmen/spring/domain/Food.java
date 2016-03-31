package com.realdolmen.spring.domain;

public abstract class Food {
    private Integer id;
    private String name;
    private int calories;

    public Food() {
    }

    public Food(int id, String name, int calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
