package com.realdolmen.spring.domain;

import java.util.Objects;

// TODO 1: Implement Restaurant. You can reuse the static method.
public interface Restaurant {
    void serveMeal(Visitor visitor);

    static void cookNewMealForVisitor(Visitor visitor) {
        Objects.requireNonNull(visitor);
        System.out.println();
        System.out.println("*****************************************");
        System.out.format("Serving a nice meal to '%s'%n", visitor.getName());
        System.out.println("*****************************************");
        System.out.println(
            "                               .-'''''-.\n" +
            "                               |'-----'|\n" +
            "                               |-.....-|\n" +
            "                               |       |\n" +
            "                               |       |\n" +
            "              _,._             |       |\n" +
            "         __.o`   o`\"-.         |       |\n" +
            "      .-O o `\"-.o   O )_,._    |       |\n" +
            "     ( o   O  o )--.-\"`O   o\"-.`'-----'`\n" +
            "      '--------'  (   o  O    o)  \n" +
            "                   `----------`"
        );
        System.out.println("*****************************************");
        System.out.println();
    }
}
