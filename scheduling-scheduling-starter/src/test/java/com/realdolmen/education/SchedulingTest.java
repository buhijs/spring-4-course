package com.realdolmen.education;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class SchedulingTest {
    @Autowired(required = false)
    private TaskScheduler taskScheduler;

    @Autowired(required = false)
    private TaskExecutor taskExecutor;

    @Autowired
    private SchedulerService schedulerService;

    @Autowired
    private BookService bookService;

    @Test
    public void taskSchedulerIsPresentInApplicationContext() throws Exception {
        assertNotNull("No scheduler found. Did you configure one in the application context?", taskScheduler);
    }

    @Test
    public void taskExecutorIsPresentInApplicationContext() throws Exception {
        assertNotNull("No executor found. Did you configure one in the application context?", taskExecutor);
    }

    @Test
    public void createBookIsExecutedAsynchronouslyInTheBackground() throws Exception {
        Book book = new Book(102, "A Game Of Thrones", "George R. R. Martin", "4657498765465", "Bantam Spectra/US & Voyager Books/UK");
        Future<Integer> result = schedulerService.createBookAsynchronously(book);// Execute asynchronously
        assertNull("The method seems to have executed synchronously rather than asynchronously", bookService.findById(102)); // Should not be there yet!
        result.get();
        assertEquals("A Game Of Thrones", bookService.findById(102).getTitle());
    }

    @Test
    public void scheduleIsExecuted() throws Exception {
        Thread.sleep(5000); // Say we wait for a couple of seconds.
        assertTrue("Not a single schedule has been executed during 5 seconds. That's not right!", schedulerService.getCount() > 0);
    }
}
