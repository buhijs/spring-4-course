package com.realdolmen.education;

import java.util.List;

public interface BookService {
    public Book findById(Integer id);
    public Book findByIsbn(String isbn);
    public List<Book> findAll();
    void create(Book book);
}
