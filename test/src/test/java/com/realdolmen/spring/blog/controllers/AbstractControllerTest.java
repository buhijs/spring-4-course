package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.BlogApplication;
import com.realdolmen.spring.blog.dao.AuthorRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

// TODO: Configure this as a Spring test for BlogApplication and "test" profile enabled
public abstract class AbstractControllerTest {
    protected MockMvc mvc;

    protected AuthorRepository repository; // This needs to be a mock! Not the real one!

    @Autowired
    protected WebApplicationContext context;

    // TODO: Create a field for a Mock of AuthorRepository

    // TODO: Setup a reuable MockMvc for AuthorController and RegistrationController
    // TODO: Make sure both controllers use the AuthorRepositoryt mock
}
