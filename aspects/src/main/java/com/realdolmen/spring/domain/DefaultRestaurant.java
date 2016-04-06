package com.realdolmen.spring.domain;

public class DefaultRestaurant implements Restaurant {

    @Override
    public void serveMeal(Visitor visitor) {
        Restaurant.cookNewMealForVisitor(visitor);
    }
}
