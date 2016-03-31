package com.realdolmen.spring.blog;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by cda5732 on 14/04/2015.
 */
@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ApplicationConfiguration.class).profiles("production").run();
        // TODO load repositories and test by inserting data into the production database
    }
}
