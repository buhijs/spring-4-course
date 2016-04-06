package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.dao.AuthorRepository;
import com.realdolmen.spring.blog.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        model.addAttribute("author", new Author());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String showRegisterForm(Model model, @Valid Author author, Errors errors) {
        if(errors.hasErrors()) {
            return "register";
        }

        authorRepository.save(author);
        return "redirect:/authors";
    }
}
