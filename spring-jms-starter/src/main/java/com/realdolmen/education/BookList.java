package com.realdolmen.education;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookList implements Serializable {
    public List<Book> books = new ArrayList<>();

    public BookList() {
    }

    public BookList(List<Book> books) {
        this.books = books;
    }

    public int size() {
        return books.size();
    }

    public void add(Book book) {
        books.add(book);
    }


}
