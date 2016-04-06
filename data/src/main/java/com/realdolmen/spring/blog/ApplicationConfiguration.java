package com.realdolmen.spring.blog;

import com.realdolmen.spring.blog.domain.Author;
import com.realdolmen.spring.blog.repository.AuthorRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ApplicationConfiguration.class).profiles("production").run();
        // TODO load repositories and test by inserting data into the production database
        Author author = new Author("Nicolas","Quartier","nicolasquartier@gmail.com","nicolasq","passwoord");
        context.getBean(AuthorRepository.class).save(author);

    }
}
