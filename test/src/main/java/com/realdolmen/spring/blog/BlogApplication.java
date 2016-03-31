package com.realdolmen.spring.blog;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BlogApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BlogApplication.class).profiles("production").run();
    }
}
