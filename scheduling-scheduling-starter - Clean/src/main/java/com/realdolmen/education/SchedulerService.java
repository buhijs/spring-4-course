package com.realdolmen.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class SchedulerService {
    @Autowired
    private BookService bookService;

    private int count = 0;

    // TODO: Add a Cron schedule for this method "every two seconds during business hours"
    public void executeBookProcessingSchedule() {
        System.out.println("Processing books");
        System.out.println("*************************");
        List<Book> books = bookService.findAll();
        for (Book book : books) {
            System.out.println("Processing book " + book);
        }
        System.out.println("*************************");
        count++;
    }

    // TODO: Make this method run aync instead of sync!
    public Future<Integer> createBookAsynchronously(Book book) {
        if(book == null) {
            throw new IllegalArgumentException("Book is mandatory");
        }
        takeItEasy();
        bookService.create(book);
        return new AsyncResult<>(book.getId());
    }

    /**
     * A business routine that takes its time.
     */
    private void takeItEasy() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            throw new RuntimeException("Unable to take it slow", exception);
        }
    }

    /**
     * Helper for easy unit testing.
     * @return The number of scheduling executions so far.
     */
    public int getCount() {
        return count;
    }
}
