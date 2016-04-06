package com.realdolmen.spring.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance
@DiscriminatorColumn(name = "food_class")
public abstract class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int calories;

    @OneToMany(mappedBy = "food", cascade = CascadeType.REMOVE)
    protected List<DietEntry> dietEntries = new ArrayList<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(calories, food.calories) &&
                Objects.equals(id, food.id) &&
                Objects.equals(name, food.name) &&
                Objects.equals(dietEntries, food.dietEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, dietEntries);
    }
}
