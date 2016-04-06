package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.dao.AuthorRepository;
import com.realdolmen.spring.blog.dao.BlogRepository;
import com.realdolmen.spring.blog.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromController;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

/**
 * Created by cda5732 on 6/10/2015.
 */
@Controller
public class BlogController {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    Validator validator;

    @RequestMapping(value="/blogs", method = RequestMethod.GET)
    public List<Blog> blogs() { return blogRepository.findAll();}

    @RequestMapping(value="/blogs/{id}/remove", method = RequestMethod.GET)
    public String removeBlog(@PathVariable("id") Long id) {
        blogRepository.delete(id);
        return "redirect:" + fromMappingName("BC#blogs").build();
    }

    @RequestMapping(value="/blog", method = RequestMethod.GET)
    public String blogForm(Model model) {
        model.addAttribute(new Blog());
        model.addAttribute(authorRepository.findAll());
        return "blog";
    }

    @RequestMapping(value="/blog", method = RequestMethod.POST)
    public String createBlog(@ModelAttribute Blog blog, BindingResult errors, @RequestParam("authorId") Optional<Long> authorId, Model model) {
        if (authorId.isPresent()) {
            blog.setAuthor(authorRepository.findOne(authorId.get()));
            if(blogRepository.findBlogByAuthor_Id(authorId.get()).isPresent()){
                errors.rejectValue("author", "error.author", "Author already has a blog!");
            }
        }
        validator.validate(blog, errors);
        if (errors.hasErrors()) {
            model.addAttribute(authorRepository.findAll());
            return "blog";
        }
        blogRepository.save(blog);
        return "redirect:" + fromMappingName("BC#blogs").build();
    }
}
