package com.realdolmen.spring.blog.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AuthorValidator.class)
public @interface AuthorConstraint {
    String message() default "Email is not valid! (Should end with 'realdolmen.be')";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};

}
