package com.realdolmen.education;


import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/**
 * This test requires the web server to be started.
 */
public class BookServiceRestClientTest {
    private static final String URL_PREFIX = "http://localhost:8080/spring-rest";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void restServiceToRetrieveAllBooksCanBeCalled() throws Exception {
        ResponseEntity<BookList> result = restTemplate.getForEntity(URL_PREFIX + "book/all", BookList.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("A Game Of Thrones", result.getBody().books.get(0).getTitle());
    }

    @Test
    public void restServiceToRetrieveASingleBookCanBeCalled() throws Exception {
        Book book = restTemplate.getForObject(URL_PREFIX + "/book/0000000000002", Book.class);
        assertEquals("Nineteen Eighty Four", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
    }

    @Test
    public void restServiceCanCreateANewBook() throws Exception {
        int sizeBefore = restTemplate.getForObject(URL_PREFIX + "/book/all", BookList.class).size();
        Book book = new Book();
        book.setId(1507);
        book.setIsbn("0000000001507");
        book.setTitle("How To Write Rest Services");
        book.setAuthor("Kevin Van Robbroeck");
        restTemplate.postForEntity(URL_PREFIX + "/book/create", book, Void.class);

        int sizeAfter = restTemplate.getForObject(URL_PREFIX + "/book/all", BookList.class).size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }
}
