package com.realdolmen.spring.blog.repository;

import com.realdolmen.spring.blog.domain.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    Page<BlogPost> findAllBlogPostOrderByCreationDateDescPaggeble(int paggable);
}
