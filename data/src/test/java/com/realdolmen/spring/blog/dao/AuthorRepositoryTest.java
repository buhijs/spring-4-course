package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.config.TestConfig;
import com.realdolmen.spring.blog.domain.Author;
import com.realdolmen.spring.blog.repository.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
// TODO Activate the test profile
@ActiveProfiles("test")
// TODO Activate transactions
@Transactional
public class AuthorRepositoryTest {

    // TODO wire in the repository
    @Autowired
    private AuthorRepository authorRepository;

    // TODO add unit tests to test the repository
    @Test
    public void shouldReturnAuthorWithIdOne() {
        Author author = authorRepository.findById(1L);
        assertEquals("Nicolas", author.getFirstName());
        assertEquals("Quartier", author.getLastName());
        assertEquals("nicolasquartier@msn.com", author.getEmail());
    }
}
