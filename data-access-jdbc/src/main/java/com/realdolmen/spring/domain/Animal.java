package com.realdolmen.spring.domain;

import java.util.Objects;

public class Animal {
    public enum Type {
        bear,
        elephant,
        tiger
    }

    private String name;
    private Type type;
    private int age;
    private String tag;

    public Animal(String name, Type type, int age, String tag) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public String getTag() {
        return tag;
    }

    public void feed(Food food) {
        Objects.requireNonNull(food, "Animals must eat something!");
        System.out.println("                     ___\n" +
                "            __..--\"\".--.`\"\"--..__\n" +
                "      _..--\"   _.--/    \\''--.   \"--..\n" +
                "    .'       .--.  '-..-'     ) (``\\  '.\n" +
                "   |   .--''/    \\-'''-. __.-' _.'  )   |\n" +
                "   ;\\ (     '-..-'      )  _.-' _.-'   /;\n" +
                "    \\'-:-._    _.._.-''`  ( ,.-'   _.-'/\n" +
                "     '-._ ``--`..___     __:.--''``_.-'\n" +
                "  jgs    ``--..___  `````  __..--``\n" +
                "                  `````````");
        System.out.format("Feeding a '%s' to '%s'%n", food.getName(), getName());
        System.out.println();
        System.out.println();
    }
}
