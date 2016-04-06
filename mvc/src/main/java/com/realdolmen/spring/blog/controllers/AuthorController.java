package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.dao.AuthorRepository;
import com.realdolmen.spring.blog.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorController {

    private List<Author> authorList;

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String getAllAuthors(Model model) {
        authorList = authorRepository.findAll();
        model.addAttribute("authorList", authorList);
        return "authors";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String removeAuthor(@RequestParam Long id) {
        authorRepository.delete(id);
        return "redirect:/authors";
    }

    @ModelAttribute("authorList")
    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
