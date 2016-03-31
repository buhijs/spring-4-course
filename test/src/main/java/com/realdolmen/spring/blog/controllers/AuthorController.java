package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.dao.AuthorRepository;
import com.realdolmen.spring.blog.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @RequestMapping(value="/{id}/remove", method = RequestMethod.GET)
    public String removeAuthor(@PathVariable("id") Long id) {
        authorRepository.delete(id);
        return "redirect:" + fromMappingName("AC#authors").build();
    }
}
