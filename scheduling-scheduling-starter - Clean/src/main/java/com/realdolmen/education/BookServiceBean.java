package com.realdolmen.education;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceBean implements BookService {
    private List<Book> books = new ArrayList<>();

    @PostConstruct
    public void initialize() {
        books.add(new Book(1, "Nineteen Eighty Four", "George Orwell", "0000000000001", "Penguin Classics"));
        books.add(new Book(2, "Animal Farm", "George Orwell", "0000000000002", "Penguin Classics"));
        books.add(new Book(3, "Brave New World", "Aldous Huxley", "0000000000003", "Wordpress"));
        books.add(new Book(4, "Alice's Adventures In Wonderland", "Lewis Carrol", "0000000000004", "Publishing Nord"));
        books.add(new Book(5, "Uncle Tom's Cabin", "Harriet Bleecher Stowe", "0000000000005", "Woodtap Brothers"));
        books.add(new Book(6, "Moby Dick", "Herman Melville", "0000000000006", "Great Sea Novels"));
        books.add(new Book(7, "The Old Man And The Sea", "Ernest Hemmingway", "0000000000007", "Great Sea Novels"));
        books.add(new Book(8, "The Wonderful Wizard of Oz", "L. Frank Baum", "0000000000008", "Children First Books"));
    }

    @Override
    public Book findById(Integer id) {
        for (Book book : books) {
            if(book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book findByIsbn(String isbn) {
        for (Book book : books) {
            if(book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public void create(Book book) {
        books.add(book);
    }
}
