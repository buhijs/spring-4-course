package com.realdolmen.spring.blog.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthorValidator implements ConstraintValidator<AuthorConstraint, String> {
    @Override
    public void initialize(AuthorConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            if (value.endsWith("@realdolmen.be")) {
                return true;
            }
        }
        return false;
    }
}
