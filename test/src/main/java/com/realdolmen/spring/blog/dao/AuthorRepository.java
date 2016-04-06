package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
