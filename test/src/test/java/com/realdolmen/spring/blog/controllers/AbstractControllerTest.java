package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.BlogApplication;
import com.realdolmen.spring.blog.dao.AuthorRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceView;

// TODO: Configure this as a Spring test for BlogApplication and "test" profile enabled
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BlogApplication.class)
@ActiveProfiles("test")
@WebAppConfiguration
public abstract class AbstractControllerTest {

    protected MockMvc mvc;

    @Autowired
    protected AuthorRepository repository; // This needs to be a mock! Not the real one!

    @Autowired
    protected WebApplicationContext context;

    protected RegistrationController registrationController;
    protected AuthorController authorController;

    // TODO: Create a field for a Mock of AuthorRepository

    // TODO: Setup a reuable MockMvc for AuthorController and RegistrationController
    // TODO: Make sure both controllers use the AuthorRepository mock
    @Before
    public void init() {
        this.repository = Mockito.mock(AuthorRepository.class);

        registrationController = new RegistrationController();
        registrationController.authorRepository = repository;

        authorController = new AuthorController();
        authorController.authorRepository = repository;

        this.mvc = MockMvcBuilders.standaloneSetup(registrationController, authorController).setSingleView(new InternalResourceView("")).build();
    }
}
