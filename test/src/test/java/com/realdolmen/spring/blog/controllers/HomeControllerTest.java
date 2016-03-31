package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.BlogApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

// TODO: Make sure JUnit runt with Spring's class runner
// TODO: Load context from BlogApplication with "test" profile active
// TODO: Configure the testing framework to use a WebApplicationContext
public class HomeControllerTest {
    @Autowired
    private WebApplicationContext context;

    // TODO: Configure a MockMVC to use in the unit test

    @Test
    public void homeControllerReturnsIndexPage() throws Exception {
        // TODO implement this unit test
        Assert.fail("todo");
    }
}
