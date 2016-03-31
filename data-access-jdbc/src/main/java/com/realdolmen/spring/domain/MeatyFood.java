package com.realdolmen.spring.domain;

public class MeatyFood extends Food {
    public enum Type {
        poultry,
        fish,
        meat
    }

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
