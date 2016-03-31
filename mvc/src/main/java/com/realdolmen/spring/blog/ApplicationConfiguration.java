package com.realdolmen.spring.blog;

import com.realdolmen.spring.blog.dao.AuthorRepository;
import com.realdolmen.spring.blog.domain.Author;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by cda5732 on 14/04/2015.
 */
@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationConfiguration.class).profiles("production").run();
    }
}
