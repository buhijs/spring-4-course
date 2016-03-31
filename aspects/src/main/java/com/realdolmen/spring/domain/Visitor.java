package com.realdolmen.spring.domain;

public class Visitor {
    private String name;
    private boolean grumpy;

    public Visitor(String name) {
        this(name, false);
    }

    public Visitor(String name, boolean grumpy) {
        this.name = name;
        this.grumpy = grumpy;
    }

    public String getName() {
        return name;
    }

    public boolean isGrumpy() {
        return grumpy;
    }

    public void orderMeal(Restaurant restaurant) {
        restaurant.serveMeal(this);
    }

    public void visit(Zoo zoo) {
        zoo.accept(this);
    }
}
