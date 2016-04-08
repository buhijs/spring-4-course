package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.Author;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// TODO Add cache rules to the following methods of AuthorRepository findAll()
// TODO Add cache rules to the following methods of AuthorRepository delete(id)
// TODO Add cache rules to the following methods of AuthorRepository save(Author)
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Cacheable(value = "ehCache", key = "'list'")
    List<Author> findAll();

    @CacheEvict(value = "ehCache", key = "'list'")
    void delete(Long aLong);

    @CacheEvict(value = "ehCache", key = "'list'")
    Author save(Author author);
}
