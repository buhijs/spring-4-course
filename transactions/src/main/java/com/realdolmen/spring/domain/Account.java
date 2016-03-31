package com.realdolmen.spring.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private int version;

    private String name;

    private BigDecimal balance;

    /**
     * Used by JPA.
     */
    protected Account() {
    }

    public Account(String name) {
        this.name = name;
        this.version = 1;
        this.balance = BigDecimal.ZERO;
    }

    public Integer getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Account '%s' has balance €%s", name, balance.toString());
    }

    void print() {
        System.out.println(toString());
    }
}
