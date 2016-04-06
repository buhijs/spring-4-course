package com.realdolmen.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class MeatyFood extends Food {
    public enum Type {
        poultry,
        fish,
        meat
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "meaty_food_type")
    private Type type;

    public MeatyFood() {
    }

    public MeatyFood(int id, String name, int calories, Type type) {
        super(id, name, calories);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
