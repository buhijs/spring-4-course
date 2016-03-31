package com.realdolmen.spring.domain;

public class Tiger extends Animal {

    public Tiger() {
        super();
    }

    public Tiger(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println("miauwtjes");
    }
}
