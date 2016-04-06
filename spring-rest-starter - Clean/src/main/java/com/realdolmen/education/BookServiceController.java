package com.realdolmen.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookServiceController {
    @Autowired
    private BookService bookService;

    // TODO: add service methods for retrieving a book by ISBN, retrieving all books, creating a book.

    // TODO: add support for JSON ("consumes" and "produces") content type: application/json. Do not forget to add a dependency in the maven project to a JSON library!
}
