package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.BlogApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// TODO: Make sure JUnit runt with Spring's class runner
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BlogApplication.class)
// TODO: Load context from BlogApplication with "test" profile active
@ActiveProfiles("test")
// TODO: Configure the testing framework to use a WebApplicationContext
@WebAppConfiguration
public class HomeControllerTest {

    @Autowired
    private WebApplicationContext context;

    // TODO: Configure a MockMVC to use in the unit test
    private MockMvc mockMvc;

    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void homeControllerReturnsIndexPage() throws Exception {
        // TODO implement this unit test
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(content().string(containsString("This is the homepage of the RealDolmen Blog.")));
        //Assert.fail("todo");
    }
}
