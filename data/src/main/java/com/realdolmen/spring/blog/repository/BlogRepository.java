package com.realdolmen.spring.blog.repository;

import com.realdolmen.spring.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
