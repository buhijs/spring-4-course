package com.realdolmen.spring.blog.repository;

import com.realdolmen.spring.blog.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findById(Long id);
}
