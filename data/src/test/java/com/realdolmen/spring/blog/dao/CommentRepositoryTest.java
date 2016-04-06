package com.realdolmen.spring.blog.dao;


import com.realdolmen.spring.blog.config.TestConfig;
import com.realdolmen.spring.blog.domain.Comment;
import com.realdolmen.spring.blog.repository.CommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
@Transactional
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void shouldReturnTop50CommentsByBlogPostIdOrderedByCreationDateDesc() {
        List<Comment> commentList = commentRepository.findFirst50ByBlogPost_IdOrderByCreationDateDesc(1L);
        assertEquals(1, commentList.size());
    }
}
