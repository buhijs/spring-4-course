package com.realdolmen.spring.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Animal {
    public enum Type {
        bear,
        donkey,
        tiger,
        pig,
        rabbit,
        owl,
        kangaroo
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    private int age;

    private String tag;

    public Animal() {
    }

    public Animal(String name, Type type, int age, String tag) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.tag = tag;
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
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
