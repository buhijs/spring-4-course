package com.realdolmen.spring.aspects;

import com.realdolmen.spring.domain.Visitor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookKeeping {

    private int happyVisitors;
    private int unhappyVisitors;

    // TODO: Add an advice that advises the Zoo.accept(Visitor) method
    // TODO: Make sure the advice uses the return value of the the adviced method to keep track of happy and unhappy visitors
    @AfterReturning(pointcut="execution(boolean com.realdolmen.spring.domain.Zoo.accept(com.realdolmen.spring.domain.Visitor))", returning="isGrumpy")
    public void countVisitors(boolean isGrumpy) {
        if(!isGrumpy) {
            unhappyVisitors++;
        }
        else {
            happyVisitors++;
        }

        System.out.println("Hello visitor!");
    }

    public int getHappyVisitorCount() {
        return happyVisitors;
    }

    public int getUnhappyVisitorCount() {
        return unhappyVisitors;
    }
}
