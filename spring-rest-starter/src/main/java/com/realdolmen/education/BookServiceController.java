package com.realdolmen.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookServiceController {
    @Autowired
    private BookService bookService;

    // TODO: add service methods for retrieving a book by ISBN, retrieving all books, creating a book.
    // TODO: add support for JSON ("consumes" and "produces") content type: application/json. Do not forget to add a dependency in the maven project to a JSON library!

    @RequestMapping(method = RequestMethod.GET, value = "/book/{isbn}",
            produces = "application/json")
    public Book getByIsbn(@PathVariable String isbn) {
        return bookService.findBookByIsbn(isbn);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/book/all",
            produces = "application/json")
    public BookList getAll() {
        return new BookList(bookService.findAllBooks());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/book/create",
            consumes = "application/json")
    public void create(@RequestBody Book book) {
        bookService.createBook(book);
    }
}
