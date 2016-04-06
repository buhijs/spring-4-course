package com.realdolmen.spring.aspects;

import com.realdolmen.spring.domain.DefaultRestaurant;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Facilities {

    // TODO: Configure a new introduction that combines Zoo and Restaurant
    @DeclareParents(value="com.realdolmen.spring.domain.Restaurant+", defaultImpl = DefaultRestaurant.class)
    public
}
