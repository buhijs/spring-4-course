package com.realdolmen.spring.blog.service;

import com.realdolmen.spring.blog.dao.AuthorRepository;
import com.realdolmen.spring.blog.dao.BlogRepository;
import com.realdolmen.spring.blog.domain.Author;
import com.realdolmen.spring.blog.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthorBlogService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BlogRepository blogRepository;

    @Transactional
    public void saveAuthorAndBlog(Author author, Blog blog) {
        Author savedAuthor = authorRepository.save(author);
        blog.setAuthor(savedAuthor);
        blog.setCreationDate(new Date());
        blogRepository.save(blog);
    }

}
