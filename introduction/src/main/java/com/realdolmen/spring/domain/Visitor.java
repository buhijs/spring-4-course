package com.realdolmen.spring.domain;

public class Visitor {

    private String name;

    public Visitor(String name) {
        this.name = name;
    }

    public Visitor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
