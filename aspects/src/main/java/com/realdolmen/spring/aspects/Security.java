package com.realdolmen.spring.aspects;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.EscapedAnimalException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Aspect
public class Security {
    @Around("execution(* com.realdolmen.spring.domain.Zoo.releaseAnimal(com.realdolmen.spring.domain.Animal)) && args(animal)")
    public Object security(ProceedingJoinPoint jp, Animal animal) throws Throwable{
        if(animal.type().equals("Chimp")) {
            jp.proceed();
            throw new EscapedAnimalException(animal);
        }
        else {
            preventEscapeOf(animal);
            return null;
        }
    }

    /**
     * Prevents escaping of an animal.
     * @param animal The animal to prevent scape of.
     */
    private void preventEscapeOf(Animal animal){
            Objects.requireNonNull(animal);
            System.out.println();
            System.out.println("***********************************************");
            System.out.format("Preventing %s '%s' from escaping!%n", animal.type(), animal.getName());
            System.out.println("***********************************************");
            System.out.println(
                    "     ||   ||     ||   ||\n" +
                            "     ||   ||, , ,||   ||\n" +
                            "     ||  (||/|/(\\||/  ||\n" +
                            "     ||  ||| _'_`|||  ||\n" +
                            "     ||   || o o ||   ||\n" +
                            "     ||  (||  - `||)  ||\n" +
                            "     ||   ||  =  ||   ||\n" +
                            "     ||   ||\\___/||   ||\n" +
                            "     ||___||) , (||___||\n" +
                            "    /||---||-\\_/-||---||\\\n" +
                            "   / ||--_||_____||_--|| \\\n" +
                            "  (_(||)-| S123-45 |-(||)_)\n" +
                            "|\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"|"
            );
            System.out.println("***********************************************");
            System.out.println();
    }
}
