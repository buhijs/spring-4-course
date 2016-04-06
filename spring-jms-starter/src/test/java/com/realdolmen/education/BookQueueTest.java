package com.realdolmen.education;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/jms-context.xml")
public class BookQueueTest {

    @Autowired(required = false)
    private JmsTemplate jmsTemplate;

    @Autowired(required = false)
    private BookService bookService;

    @Autowired(required = false)
    private CachingConnectionFactory cachingConnectionFactory;

    @Autowired(required = false)
    private BookQueueMessageListener messageListener;

    @Test
    public void jmsTemplateIsConfiguredCorrectly() throws Exception {
        assertNotNull("A JMS template is required if you wish to interact with a JMS queue from the client side.", jmsTemplate);
        assertNotNull("Configure a default destination on the JMS template", jmsTemplate.getDefaultDestination());
    }

    @Test
    public void cachingConnectionFactoryIsConfigured() throws Exception {
        assertNotNull("You should add a caching connection factory to the context", cachingConnectionFactory);
    }

    @Test
    public void messagesAreArrivingInTheQueue() throws Exception {
        int before = bookService.countBooks();
        BookList message = new BookList();
        message.add(new Book(1, "Sample book 1", "Sample author 1", "Sample isbn 1"));
        message.add(new Book(2, "Sample book 2", "Sample author 2", "Sample isbn 2"));
        message.add(new Book(3, "Sample book 3", "Sample author 3", "Sample isbn 3"));
        message.add(new Book(4, "Sample book 4", "Sample author 4", "Sample isbn 4"));
        message.add(new Book(5, "Sample book 5", "Sample author 5", "Sample isbn 5"));
        assertNotNull("Next to a towel, a JMSTemplate is the most useful thing to have in the galaxy. You do not seem to have it!", jmsTemplate);
        jmsTemplate.convertAndSend(message);
        Thread.sleep(2000); // Let it wait for async processing to complete.
        assertEquals(before + message.size(), bookService.countBooks());
    }

    @Test
    public void aMessageListenerIsActive() throws Exception {
        assertNotNull("Woe upon those who do not have a BookQueueMessageListener in their application context!", messageListener);
    }
}
