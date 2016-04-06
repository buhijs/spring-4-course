package com.realdolmen.education;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BookServiceBean implements BookService {
    private List<Book> books = new ArrayList<>();

    private String bookStoreName;
    private Set<String> managers;

    @Override
    public String getBookStoreName() {
        return bookStoreName;
    }

    @Override
    public Set<String> getManagers() {
        return managers;
    }

    @Override
    public String findBookTitleByIsbn(String isbn) {
        Book book = findBookByIsbn(isbn);
        if(book == null) {
            return null;
        }
        return book.getTitle();
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if(book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public void createBook(Book book) {
        books.add(book);
    }

    @Override
    public int countBooks() {
        return books.size();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setBookStoreName(String bookStoreName) {
        this.bookStoreName = bookStoreName;
    }

    public void setManagers(Set<String> managers) {
        this.managers = managers;
    }
}
