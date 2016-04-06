package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.dao.AuthorRepository;
import com.realdolmen.spring.blog.dao.BlogRepository;
import com.realdolmen.spring.blog.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

/**
 * Created by cda5732 on 16/04/2015.
 */
@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BlogRepository blogRepository;

    // TODO Exercise 5: Add a filter to the AuthorController, so you will not return the "admin" user in the list
    @RequestMapping(method = RequestMethod.GET)
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @RequestMapping(value = "/{id}/remove", method = RequestMethod.GET)
    public String removeAuthor(@PathVariable("id") Long id, Model model) {
        if (blogRepository.findBlogByAuthor_Id(id).isPresent()) {
            model.addAttribute("error", "Unable to delete author: author has a Blog!");
            model.addAttribute(authors());
            return fromMappingName("AC#authors").build();
        } else {
            authorRepository.delete(id);
        }
        return "redirect:" + fromMappingName("AC#authors").build();
    }
}
