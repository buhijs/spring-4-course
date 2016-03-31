package com.realdolmen.spring.domain;

import java.util.Objects;

public class Animal {
    public enum Type { Chimp, Lion, Tiger, Elephant, Hippo, Panda }

    private Integer id;
    private String name;
    private Type type;

    public Animal() {
    }

    public Animal(String name, Type type) {
        this(null, name, type);
    }

    public Animal(Integer id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
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
        Objects.requireNonNull(name, "Animal name is required");
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        Objects.requireNonNull(type, "Animal type is required");
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        Animal other = (Animal)o;
        return this.name.equals(other.name) && this.type == other.type;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * type.hashCode();
    }
}
