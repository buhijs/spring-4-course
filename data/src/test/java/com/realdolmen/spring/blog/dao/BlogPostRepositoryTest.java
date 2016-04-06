package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.config.TestConfig;
import com.realdolmen.spring.blog.repository.BlogPostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
@Transactional
public class BlogPostRepositoryTest {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Test
    public void shouldReturnTop50CommentsByBlogPostIdOrderedByCreationDateDesc() {
    }
}
