package com.realdolmen.spring.domain;

public interface Zoo {
    void addAnimal(Animal animal);

    void releaseAnimal(Animal animal);

    /**
     * Accepts a visitor to our zoo.
     * @param visitor The visitor to visit us.
     * @return True if the visitor had a good time.
     */
    boolean accept(Visitor visitor);

    String getName();

    Animal getAnimalByName(String name);

    int countAnimals();
}
