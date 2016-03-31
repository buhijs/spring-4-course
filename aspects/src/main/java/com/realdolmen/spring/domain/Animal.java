package com.realdolmen.spring.domain;

import java.util.Objects;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        Objects.requireNonNull(name, () -> "Animal name is required");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void escapeFrom(Zoo zoo) {
        zoo.releaseAnimal(this);
    }

    @Override
    public boolean equals(Object o) {
        return name.equals(((Animal)o).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String type() {
        return getClass().getSimpleName();
    }

}
