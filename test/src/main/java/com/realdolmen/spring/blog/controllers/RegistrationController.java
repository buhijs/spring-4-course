package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.dao.AuthorRepository;
import com.realdolmen.spring.blog.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Author register() {
        return new Author();
    }

    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public String saveAuthor(@Valid Author author, BindingResult errors) {
        if (errors.hasErrors()) {
            return "/register";
        }
        authorRepository.save(author);
        return "redirect:/authors";
    }
}
