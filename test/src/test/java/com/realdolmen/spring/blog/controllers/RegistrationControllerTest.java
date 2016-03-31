package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.domain.Author;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class RegistrationControllerTest extends AbstractControllerTest {
    @Test
    public void formValidationFailure() throws Exception {
        Assert.fail("todo");
        // TODO: Write a unit test that verifies if a form with invalid input fails
    }

    @Test
    public void formValidationSuccess() throws Exception {
        Assert.fail("todo");
        // TODO: Write a unit test that verifies if a form with valid input calls the repository's save() method
    }
}
