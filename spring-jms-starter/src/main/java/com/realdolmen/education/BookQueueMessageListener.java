package com.realdolmen.education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Message;
import javax.jms.MessageListener;
import java.io.Serializable;

// TODO: Make sure this class is loaded into the context. THis will be sort of like a MessageDrivenBean from JEE's EJB Specification, only better!
@Component
public class BookQueueMessageListener{
    private Log log = LogFactory.getLog(getClass());

    @Autowired
    private BookService bookService;

    // TODO: add a method that receives a BookList and passes all books to the BookService.createBook() method
    public void receiveBookList(Serializable list) {
        BookList booklist = (BookList) list;

        for (Book book : booklist.books) {
            bookService.createBook(book);
        }
    }

}
