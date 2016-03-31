package com.realdolmen.spring.domain;

public class Bug extends RuntimeException {
    public static void causeMischief(String why) {
        throw new Bug(why);
    }

    private Bug(String why) {
        super(String.format("Causing mischief because %s", why));
    }
}
