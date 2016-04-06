package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.domain.Author;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RegistrationControllerTest extends AbstractControllerTest {

    @Test
    public void formValidationFailure() throws Exception {
        // TODO: Write a unit test that verifies if a form with invalid input fails
        mvc.perform(post("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("/register"))
                .andExpect(model().hasErrors());
    }

    @Test
    public void formValidationSuccess() throws Exception {
        // TODO: Write a unit test that verifies if a form with valid input calls the repository's save() method
        mvc.perform(post("/register")
                .param("firstName", "Nicolas")
                .param("lastName", "Quartier")
                .param("email", "nicolasquartier@realdolmen.be")
                .param("userName", "nicolasq")
                .param("password", "q"))
        .andExpect(status().isOk())
        .andExpect(view().name("redirect:/authors"))
        .andExpect(model().hasNoErrors());

        Mockito.verify(repository).save(any(Author.class));
    }
}
