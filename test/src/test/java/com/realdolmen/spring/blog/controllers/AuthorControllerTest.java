package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.domain.Author;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class AuthorControllerTest extends AbstractControllerTest {
    @Test
    public void authorsDisplaysList() throws Exception {
        // TODO: Implement a unit test to verify that /authors puts a list of authors on the model
        Assert.fail("todo");
    }

    private List<Author> dummyAuthors() {
        return Arrays.asList(
            new Author("email1", "username1", "password1"),
            new Author("email2", "username2", "password2")
        );
    }

    @Test
    public void removePropagatesToRepositoryDelete() throws Exception {
        // TODO: Implement a unit test to verify that /authors/1/remove removes the author from the repository
    }
}
