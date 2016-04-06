package com.realdolmen.education;

import java.util.List;
import java.util.Set;

public interface BookService {
    String getBookStoreName();
    Set<String> getManagers();
    String findBookTitleByIsbn(String isbn);
    Book findBookByIsbn(String isbn);
    List<Book> findAllBooks();
    void createBook(Book book);
}