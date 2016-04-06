package com.realdolmen.education;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class BookList {
    @XmlElement(name = "book")
    public List<Book> books;

    public BookList() {
    }

    public BookList(List<Book> books) {
        this.books = books;
    }

    public int size() {
        return books.size();
    }


}
