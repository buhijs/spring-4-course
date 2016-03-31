package com.realdolmen.spring;

import com.realdolmen.spring.domain.Account;
import com.realdolmen.spring.domain.Bank;
import com.realdolmen.spring.domain.Bug;
import org.springframework.boot.SpringApplication;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Bank bank = SpringApplication.run(BankConfig.class, args).getBean(Bank.class);

        // TODO: Do some maintenance for our bank: after all, we need to make sure everything keeps running smoothly, right?

        System.out.println();

        System.out.println("Opening accounts");
        System.out.println("----------------");
        Account checking = bank.openAccount(new Account("Checking account"));
        Account savings = bank.openAccount(new Account("Savings account"));

        try {
            System.out.println();
            System.out.println("Performing financial transactions");
            System.out.println("---------------------------------");
            checking = bank.transfer(new BigDecimal("1000"), checking);
            savings = bank.transfer(new BigDecimal("250"), checking, savings);
        } catch(Bug b) {
            b.printStackTrace(System.out);
        } finally {
            System.out.println();
            System.out.println("Printing account balances");
            System.out.println("-------------------------");
            bank.printAccounts();
        }

        System.out.println();
    }
}
