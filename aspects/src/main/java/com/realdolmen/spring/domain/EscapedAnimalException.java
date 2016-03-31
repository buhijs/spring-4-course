package com.realdolmen.spring.domain;

public class EscapedAnimalException extends RuntimeException {
    public EscapedAnimalException(Animal animal) {
        super("EMERGENCY! Animal escaped: " + animal.getName());
    }
}
